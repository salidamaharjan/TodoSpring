package dev.smhr.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoStore {
    private final List<String> todoList;

    public TodoStore() {
        todoList = new ArrayList<>();
        todoList.add("Cook");
        todoList.add("Clean");
    }

    public List<String> getTodoList() {
        return todoList;
    }
//    public void setTodoList(Task task){
//        this.todoList.add(task);
//    }
}
