package com.example.todoapplication.domain.tasks.repository;

import com.example.todoapplication.domain.tasks.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface TaskRepository extends JpaRepository<Task, Long> {

  List<Task> findAllByCaption(String caption);
  List<Task> findAllByCheck(Boolean check);
}