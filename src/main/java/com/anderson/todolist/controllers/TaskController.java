package com.anderson.todolist.controllers;

import com.anderson.todolist.entities.Task;
import com.anderson.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/{id}")
    public ResponseEntity<Task> insert(@PathVariable Long id, @RequestBody Task obj) {
        Task task = service.insert(id, obj);
        return ResponseEntity.ok().body(task);
    }
}
