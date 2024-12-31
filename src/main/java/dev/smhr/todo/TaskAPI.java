package dev.smhr.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskAPI {
    private final TodoStore todoStore;

    @Autowired
    public TaskAPI(TodoStore todoStore){
        this.todoStore = todoStore;
    }

    @GetMapping
    public List<String> getTodoStore(){
        return todoStore.getTaskList();
    }
}
