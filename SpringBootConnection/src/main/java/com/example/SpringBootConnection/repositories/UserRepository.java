package com.example.SpringBootConnection.repositories;

import com.example.SpringBootConnection.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
