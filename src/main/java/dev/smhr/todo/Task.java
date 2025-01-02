package dev.smhr.todo;

public class Task {
    private String taskName;
    private Boolean completed;

    public Task() {
        taskName = "";
        completed = false;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

