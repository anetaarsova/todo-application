package com.example.todoapplication.domain.tasks.service;


import com.example.todoapplication.domain.tasks.model.Task;
import com.example.todoapplication.domain.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listTasks() {
      return taskRepository.findAll();
  }

  public Task getById(Long id){
      return taskRepository.getById(id);
  }

  public Task saveOrUpdate(Task task){
      return taskRepository.save(task);
  }

  public void delete(Long id){
      taskRepository.deleteById(id);
  }

  public Collection<Task> findByCaption(String caption){
      return taskRepository.findAllByCaption(caption);
  }

    public Collection<Task> findByCompleted(boolean isCompleted){
        return taskRepository.findAllByCompleted(isCompleted);
    }
}
