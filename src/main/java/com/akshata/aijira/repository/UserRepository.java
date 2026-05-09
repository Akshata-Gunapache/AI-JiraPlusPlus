package com.akshata.aijira.repository;

import com.akshata.aijira.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
