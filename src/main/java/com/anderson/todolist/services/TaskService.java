package com.anderson.todolist.services;

import com.anderson.todolist.entities.Task;
import com.anderson.todolist.entities.User;
import com.anderson.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    @Autowired
    private UserService service;

    public Task insert(Long id, Task obj) {
        User user = service.saveTaskToUser(id, obj);
        obj.setUser(user);

        return repository.save(obj);
    }

}
