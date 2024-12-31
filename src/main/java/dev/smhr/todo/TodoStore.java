package dev.smhr.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoStore {
    private final List<String> taskList;
    public TodoStore(){
        taskList = new ArrayList<>();
        taskList.add("Cook");
        taskList.add("Study");
    }

    public List<String> getTaskList() {
        return taskList;
    }
    public void setTaskList(Task task){
        this.taskList.add(task.getTask());
    }
}
