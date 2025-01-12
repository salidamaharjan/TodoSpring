package dev.smhr.todo.taskStore;

import dev.smhr.todo.Task;

import java.util.List;

public interface TaskStoreInterface {
    List<Task> getTask();

    void addTask(Task task);

    void editTask(Integer id, Task updateTask);

    void deleteTask(Integer id);

}