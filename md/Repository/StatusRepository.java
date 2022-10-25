package com.testblog.md.Repository;

import com.testblog.md.Models.User;
import com.testblog.md.Models.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<UserStatus, String> {
}
