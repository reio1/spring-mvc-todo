/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reio.learning.first_web_app.service;

import at.reio.learning.first_web_app.model.Todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author reio
 */
@Service
public class TodoService {

    private List<Todo> todos;
    private static int idGen = 1;

    @PostConstruct
    public void init() {
        todos = new ArrayList<>();
        todos.add(new Todo(idGen++, "reio", "Cachen gehen", LocalDate.now(), false));
        todos.add(new Todo(idGen++, "reio", "Spring lernen", LocalDate.now(), false));
        todos.add(new Todo(idGen++, "reio", "Skriptum schreiben", LocalDate.now(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        return todos.stream()
                .filter(todo -> todo.getUser().equalsIgnoreCase(user))
                .collect(Collectors.toList());
    }

    public Optional<Todo> retrieveTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

//    TODO: refactor Update TODO
//    public boolean updateTodo(Todo todo) {
//        todos.remove(todo);
//        todos.add(todo);
//    }

    public void addTodo(String name, String desc, LocalDate targetDate,
            boolean isDone) {
        todos.add(new Todo(idGen++, name, desc, targetDate, isDone));
    }

    public boolean deleteTodo(int id) {
        Optional<Todo> toDel = this.retrieveTodo(id);
        if(toDel.isPresent()) {
            return todos.remove(toDel.get());
        } else {
            return false;
        }
    }

}
