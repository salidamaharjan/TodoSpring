package dev.smhr.todo;

import java.util.List;

public interface TaskStoreInterface {
    List<Task> getTask();

    void addTask(Task task);

    void editTask(Integer index, Task updateTask);

    void deleteTask(int index);

}