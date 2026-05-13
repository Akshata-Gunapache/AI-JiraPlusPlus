package com.akshata.aijira.controller;

import com.akshata.aijira.dto.ProjectRequest;
import com.akshata.aijira.model.Project;
import com.akshata.aijira.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }
}