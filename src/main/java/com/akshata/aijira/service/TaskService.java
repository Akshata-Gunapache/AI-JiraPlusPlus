package com.akshata.aijira.service;

import com.akshata.aijira.model.Task;
import com.akshata.aijira.model.TaskStatus;
import com.akshata.aijira.model.User;
import com.akshata.aijira.repository.TaskRepository;
import com.akshata.aijira.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import com.akshata.aijira.model.Priority;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final AIService aiService;

    public Task createTask(Task task) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setCreatedBy(user);

        String combinedText = task.getTitle() + " " + task.getDescription();

        String predictedPriority = aiService.predictPriority(combinedText);

        task.setPriority(Priority.valueOf(predictedPriority));

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return taskRepository.findByCreatedByEmail(email);
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task assignTask(Long taskId, Long userId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setAssignedUser(user);

        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long taskId, TaskStatus status) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        return taskRepository.save(task);
    }
}