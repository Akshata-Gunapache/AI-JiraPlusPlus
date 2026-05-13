package com.akshata.aijira.service;

import com.akshata.aijira.dto.TaskRequest;
import com.akshata.aijira.model.Project;
import com.akshata.aijira.model.Task;
import com.akshata.aijira.repository.ProjectRepository;
import com.akshata.aijira.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public Task createTask(TaskRequest request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setProject(project);

        Task savedTask = taskRepository.save(task);

        messagingTemplate.convertAndSend("/topic/tasks", savedTask);

        return savedTask;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}