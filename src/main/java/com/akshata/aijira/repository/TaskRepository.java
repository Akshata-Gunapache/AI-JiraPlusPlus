package com.akshata.aijira.repository;

import com.akshata.aijira.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}