package com.taskmaneger.assi2.repository;

import com.taskmaneger.assi2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
