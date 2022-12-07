package com.springdb.SpringDB.repositories;

import com.springdb.SpringDB.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
