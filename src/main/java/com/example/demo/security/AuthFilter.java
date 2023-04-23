package com.example.demo.security;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Component
@Slf4j
public class AuthFilter implements Filter {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    String authHeader = request.getHeader("Authorization");
    authHeader = authHeader.replaceAll("Basic " , "");
    log.debug("authHeader  : {}" , authHeader);
    String[] creds = new String(Base64.getDecoder().decode(authHeader.getBytes(StandardCharsets.UTF_8))).split(":");
    String email = creds[0];
    String password = creds[1];
    User userDetails = userRepository.findByEmail(email);
      boolean matched = passwordEncoder.matches(password, userDetails.getPassword());
      if(matched){
        var token = UsernamePasswordAuthenticationToken.authenticated(userDetails , userDetails.getPassword() ,
            List.of(new SimpleGrantedAuthority(userDetails.isAdmin() ? "ADMIN" : "USER")));
        SecurityContextHolder.getContext().setAuthentication(token);
      }
      filterChain.doFilter(servletRequest, servletResponse);
    }
}
