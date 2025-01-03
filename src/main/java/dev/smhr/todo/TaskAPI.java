package dev.smhr.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskAPI {
    private final InMemoryTaskStore todoStore;

    @Autowired
    public TaskAPI(InMemoryTaskStore todoStore){
        this.todoStore = todoStore;
    }

    @GetMapping
    public List<Task> getTodoStore(){
        return todoStore.getTask();
    }

    @PostMapping
    public ResponseEntity<String> addTask(@Valid @RequestBody Task task){
        todoStore.addTask(task);
        return ResponseEntity.ok(task.getTaskName() + " added");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editTask(@PathVariable Integer index, @Valid @RequestBody Task updatedTask){
        if (index < 0 || index >= todoStore.getTask().size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with index " + index + " not found");
        }
        todoStore.editTask(index,updatedTask);
        return ResponseEntity.ok("Task changed");
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteTask(@PathVariable int index){
        todoStore.getTask().remove(index);

        return ResponseEntity.ok("Task Deleted");
    }
}
