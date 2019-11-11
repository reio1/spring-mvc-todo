/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reio.learning.first_web_app.presentation;

import at.reio.learning.first_web_app.model.Todo;
import at.reio.learning.first_web_app.service.TodoService;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author reio
 */
@Controller
@SessionAttributes("username")
public class TodoController {
    
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping("/list-todos")
    public String showTodoList(Model model) {
        String username = (String) model.getAttribute("username");
        model.addAttribute("todos", todoService.retrieveTodos(username));
        return "list-todos";
    }
    
    @GetMapping("/add-todo")
    public String addTodo(Model model) {
        String username = (String) model.getAttribute("username");
        Todo todo = new Todo(0, username, "Default description", LocalDate.now(), false);
        model.addAttribute("todo", todo);
        //model.addAttribute("todos", todoService.retrieveTodos(username));
        return "add-update-todo";
    }
    
    @GetMapping("/delete-todo/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
    
    @PostMapping("/add-todo")
    public String addTodo(Model model, @Valid Todo todo, BindingResult results) {
        if(results.hasErrors()) {
            return "add-update-todo";
        }
        String username = (String) model.getAttribute("username");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now(), false);
        return "redirect:/list-todos";
    }
    
    
}
