package dev.smhr.todo;

import jakarta.validation.constraints.NotBlank;

public class Task {
    private int id;
    @NotBlank
    private String taskName;
    private Boolean completed;

    public Task() {
        taskName = null;
        completed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

