package dev.smhr.todo;

import java.util.List;

public interface TaskStoreInterface {
    List<Task> getTask();

    void setTask();

    void editTask();

    void deleteTask();

}