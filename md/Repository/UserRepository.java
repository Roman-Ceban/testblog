package com.testblog.md.Repository;

import com.testblog.md.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
}
