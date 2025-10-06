package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }
    public List<Task> getAllTasks() { return repo.findAll(); }
    public Optional<Task> getTaskById(Long id) { return repo.findById(id); }
    public Task createTask(Task task) { return repo.save(task); }
    public Task updateTask(Long id, Task taskDetails) {
        return repo.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setCategory(taskDetails.getCategory());
                    task.setDueDate(taskDetails.getDueDate());
                    task.setCompleted(taskDetails.isCompleted());
                    return repo.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }
    public void deleteTask(Long id) { repo.deleteById(id); }
}
