package com.taskmaneger.assi2.repository;

import com.taskmaneger.assi2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
