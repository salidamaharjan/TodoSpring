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
    private final TaskStore todoStore;

    @Autowired
    public TaskAPI(TaskStore todoStore){
        this.todoStore = todoStore;
    }

    @GetMapping
    public List<Task> getTodoStore(){
        return todoStore.getTasks();
    }

    @PostMapping
    public ResponseEntity<String> setTask(@Valid @RequestBody Task task){
        todoStore.addTask(task);
        return ResponseEntity.ok(task.getTaskName() + " added");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editTask(@PathVariable Integer index, @Valid @RequestBody Task updatedTask){
        if (index < 0 || index >= todoStore.getTasks().size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with index " + index + " not found");
        }
        Task taskToBeChanged = todoStore.getTasks().get(index);
        taskToBeChanged.setTaskName(updatedTask.getTaskName());
        taskToBeChanged.setCompleted(updatedTask.getCompleted());
        return ResponseEntity.ok("Task changed");
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteTask(@PathVariable int index){
        todoStore.getTasks().remove(index);

        return ResponseEntity.ok("Task Deleted");
    }
}
