package com.akshata.aijira.repository;

import com.akshata.aijira.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
