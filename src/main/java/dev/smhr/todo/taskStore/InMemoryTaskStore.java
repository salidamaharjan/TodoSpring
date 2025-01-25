package dev.smhr.todo.taskStore;

import dev.smhr.todo.Task;
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
    public Task getTaskById(Integer id){
        return null;
    }
    @Override
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    @Override
    public void editTask(Integer index, Task updateTask) {
        Task taskTobeChanged = taskList.get(index);
        taskTobeChanged.setTaskName(updateTask.getTaskName());
        taskTobeChanged.setCompleted(updateTask.getCompleted());
    }

    @Override
    public void deleteTask(Integer id) {
        taskList.remove(id);
    }
}
