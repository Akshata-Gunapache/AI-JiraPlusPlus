package com.akshata.aijira.repository;

import com.akshata.aijira.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCreatedByEmail(String email);
}