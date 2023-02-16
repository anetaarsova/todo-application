package com.example.todoapplication.domain.tasks.repository;

import com.example.todoapplication.domain.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Long> {

  Collection<Task> findAllByCaption(String caption);
  Collection<Task> findAllByCompleted(boolean isCompleted);
}