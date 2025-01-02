package dev.smhr.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Task> getTodoStore(){
        return todoStore.getTaskList();
    }

    @PostMapping
    public ResponseEntity<String> setTask(@RequestBody String task){
        Task newTask = new Task();
        newTask.setTaskName(task);
        todoStore.setTaskList(newTask);
        return ResponseEntity.ok(task + " added");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editTask(@PathVariable Integer index, @RequestBody String newTask){
        Task taskToBeChanged = todoStore.getTaskList().get(index);
        taskToBeChanged.setTaskName(newTask);
        return ResponseEntity.ok("Task changed");
    }
}
