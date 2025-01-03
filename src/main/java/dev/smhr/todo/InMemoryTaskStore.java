package dev.smhr.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTaskStore {
    private final List<Task> taskList;

    public InMemoryTaskStore(){
        taskList = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return taskList;
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }
}
