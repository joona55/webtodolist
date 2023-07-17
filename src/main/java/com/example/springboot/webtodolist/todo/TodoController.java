package com.example.springboot.webtodolist.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("listtodos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName("joona");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

}
