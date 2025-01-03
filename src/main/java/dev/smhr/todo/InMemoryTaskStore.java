package dev.smhr.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTaskStore implements TaskStoreInterface {
    private final List<Task> taskList;

    public InMemoryTaskStore() {
        taskList = new ArrayList<>();
    }


    @Override
    public List<Task> getTask() {
        return taskList;
    }

    @Override
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    @Override
    public void editTask() {

    }

    @Override
    public void deleteTask() {

    }
}
