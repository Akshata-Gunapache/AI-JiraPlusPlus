package com.akshata.aijira.controller;

import com.akshata.aijira.model.Task;
import com.akshata.aijira.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.akshata.aijira.model.TaskStatus;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }

    @PutMapping("/{taskId}/assign/{userId}")
    public Task assignTask(
            @PathVariable Long taskId,
            @PathVariable Long userId) {
        return taskService.assignTask(taskId, userId);
    }

    @PutMapping("/{taskId}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long taskId,
            @RequestParam TaskStatus status) {

        Task updatedTask = taskService.updateTaskStatus(taskId, status);

        return ResponseEntity.ok(updatedTask);
    }
}