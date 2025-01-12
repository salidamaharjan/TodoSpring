package dev.smhr.todo;

import dev.smhr.todo.taskStore.TaskStoreInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskAPI {
    private final TaskStoreInterface todoStore;

    @Autowired
    public TaskAPI(@Qualifier("dbTaskStore") TaskStoreInterface todoStore) {
        this.todoStore = todoStore;
    }

    @GetMapping
    public List<Task> getTodoStore() {
        return todoStore.getTask();
    }

    @PostMapping
    public ResponseEntity<String> addTask(@Valid @RequestBody Task task) {
        todoStore.addTask(task);
        return ResponseEntity.ok(task.getTaskName() + " added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editTask(@PathVariable int id, @Valid @RequestBody Task updatedTask) {
        if (id < 1 || id >= todoStore.getTask().size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with index " + id + " not found");
        }
        todoStore.editTask(id, updatedTask);
        return ResponseEntity.ok("Task changed of id: "  + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        todoStore.deleteTask(id);
        return ResponseEntity.ok("Task Deleted");
    }
}
