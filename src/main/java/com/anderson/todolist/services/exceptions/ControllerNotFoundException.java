package com.anderson.todolist.services.exceptions;

public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException (Object id) {
        super("Resource Not Found. Id " + id);
    }
}
