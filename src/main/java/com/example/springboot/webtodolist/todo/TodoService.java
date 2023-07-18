package com.example.springboot.webtodolist.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 1;

    static {
        todos.add(new Todo(todosCount++, "joona", "Learn Spring",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "joona", "Learn React",
                LocalDate.now().plusYears(1), true));
        todos.add(new Todo(todosCount++, "joona", "Learn Node.js",
                LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }

    public void addTodo(String userName, String description,
                        LocalDate localDate, Boolean done) {
       Todo todo = new Todo(todosCount++, userName, description, localDate, done);
       todos.add(todo);
    }

    public void deleteById(int id) {
        /*
        Predicate<T>로 사용되고 여기서 T는 파라미터이자 조건이다.
        T가 true 또는 false를 return 하도록한다.
        */
        // todo -> todo.getid() == id;
        Predicate<? super Todo> predicate
                        = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {

        // todo -> todo.getid() == id;
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
