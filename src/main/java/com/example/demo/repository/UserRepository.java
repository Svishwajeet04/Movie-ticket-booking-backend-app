package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "select * from users where email = :email" , nativeQuery = true)
  User findByEmail(String email);

}
