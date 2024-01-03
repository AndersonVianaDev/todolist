package com.anderson.todolist.services;

import com.anderson.todolist.entities.Task;
import com.anderson.todolist.entities.User;
import com.anderson.todolist.repositories.UserRepository;
import com.anderson.todolist.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User obj) {
        return repository.save(obj);
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    public User saveTaskToUser(Long id, Task task) {
        User user = findById(id);
        user.getTasks().add(task);

        return repository.save(user);
    }
}
