package dev.smhr.todo.taskStore;

import dev.smhr.todo.Task;

import java.util.List;

public interface TaskStoreInterface {
    List<Task> getTask();

    void addTask(Task task);

    void editTask(Integer index, Task updateTask);

    void deleteTask(int index);

}