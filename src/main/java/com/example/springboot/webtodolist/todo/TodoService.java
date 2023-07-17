package com.example.springboot.webtodolist.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "joona", "Learn Spring",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "joona", "Learn React",
                LocalDate.now().plusYears(1), true));
        todos.add(new Todo(3, "joona", "Learn Node.js",
                LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }
}
