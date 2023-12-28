package com.anderson.todolist.services;

import com.anderson.todolist.entities.User;
import com.anderson.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User obj) {
        return repository.save(obj);
    }
}
