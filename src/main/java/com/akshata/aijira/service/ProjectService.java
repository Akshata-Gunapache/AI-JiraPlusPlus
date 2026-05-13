package com.akshata.aijira.service;

import com.akshata.aijira.dto.ProjectRequest;
import com.akshata.aijira.model.Project;
import com.akshata.aijira.model.User;
import com.akshata.aijira.repository.ProjectRepository;
import com.akshata.aijira.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository,
            UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(ProjectRequest request) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        Project project = new Project();

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setUser(user);

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}