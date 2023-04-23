package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {

  @Autowired
  private UserRepository adminRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    User admin = User.builder()
        .email("admin@gmail.com")
        .name("admin")
        .admin(true)
        .password(passwordEncoder.encode("string"))
        .build();
    User existing = adminRepository.findByEmail(admin.getEmail());
    if(existing == null){
      adminRepository.save(admin);
    }
  }
}
