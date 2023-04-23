package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<User, Long> {
}

