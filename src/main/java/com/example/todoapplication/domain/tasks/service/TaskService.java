package com.example.todoapplication.domain.tasks.service;


import com.example.todoapplication.domain.tasks.model.Task;
import com.example.todoapplication.domain.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
  @Autowired
    TaskRepository taskRepository;
  public List<Task> listTasks() {
      return taskRepository.findAll();
  }

  public Task getById(Long id){
      return taskRepository.findById(id).get();
  }

  public void saveOrUpdate(Task task){
      taskRepository.save(task);
  }

  public void delete(Long id){
      taskRepository.deleteById(id);
  }

  public List<Task> findByCaption(String caption){
      return taskRepository.findAllByCaption(caption);
  }

    public List<Task> findByCheck(Boolean check){
        return taskRepository.findAllByCheck(check);
    }
}
