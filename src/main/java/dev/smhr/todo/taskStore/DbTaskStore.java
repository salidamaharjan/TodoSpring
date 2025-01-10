package dev.smhr.todo.taskStore;

import dev.smhr.todo.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbTaskStore implements TaskStoreInterface{

    @Override
    public List<Task> getTask() {
        return List.of();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void editTask(Integer index, Task updateTask) {

    }

    @Override
    public void deleteTask(int index) {

    }
}
