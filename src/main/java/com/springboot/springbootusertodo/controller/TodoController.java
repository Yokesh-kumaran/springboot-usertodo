package com.springboot.springbootusertodo.controller;

import com.springboot.springbootusertodo.model.Todo;
import com.springboot.springbootusertodo.request.TodoRequest;
import com.springboot.springbootusertodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getAllTodo(@PathVariable int userId){
        return todoService.findAll(userId);
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody TodoRequest todo){
        return todoService.create(todo);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo){
        return todoService.update(todo);
    }
    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable Integer id){
        return todoService.delete(id);
    }
}
