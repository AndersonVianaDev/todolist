package com.anderson.todolist.services;

import com.anderson.todolist.entities.Task;
import com.anderson.todolist.entities.User;
import com.anderson.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Task findById(Long id) {
        Optional<Task> obj = repository.findById(id);

        return obj.get();
    }

    public void deleteTask(Long id) {
        Task obj = findById(id);
        repository.delete(obj);
    }

    public Task updateTask(Long id, Task task) {
        Task obj = findById(id);
        obj.setConcluded(task.getConcluded());

        return repository.save(obj);
    }

}
