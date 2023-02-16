package com.example.todoapplication.domain.tasks;

import com.example.todoapplication.domain.tasks.model.Task;
import com.example.todoapplication.domain.tasks.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

   private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Collection<Task>> getAllTasks(){
        return new  ResponseEntity<>(taskService.listTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task payload ){
        try {
            var task = taskService.saveOrUpdate(payload);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Long id) {
        try {
            taskService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
