package com.springboot.springbootusertodo.service;

import com.springboot.springbootusertodo.model.AppUser;
import com.springboot.springbootusertodo.model.Todo;
import com.springboot.springbootusertodo.repository.TodoRepository;
import com.springboot.springbootusertodo.repository.UserRepository;
import com.springboot.springbootusertodo.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> create(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = userRepository.findById(todo.getId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> delete(Integer id) {
        int userId = todoRepository.findById(id).get().getUser().getId();
        todoRepository.deleteById(id);
        return  findAll(userId);
    }
}
