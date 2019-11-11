/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reio.learning.first_web_app.model;

import java.time.LocalDate;
import javax.validation.constraints.Size;

/**
 *
 * @author reio
 */
public class Todo {
    
    
    private int id = 0;
    private String user;
    
    @Size(min = 8, message = "Description must have at least 8 characters")
    private String description;
    private LocalDate target;
    private boolean isDone = false;
    
    public Todo() {
        //this(0, "", "", LocalDate.now(), false);
    }

    public Todo(int id, String user, String description, LocalDate target, boolean isDone) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.target = target;
        this.isDone = isDone;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", user=" + user + ", description=" + description + ", target=" + target + ", isDone=" + isDone + '}';
    }

}
