package dev.smhr.todo.taskStore;

import dev.smhr.todo.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllTasks {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    private static final String SELECT_ALL_TASKS = "SELECT * FROM tasks order by id";

    public List<Task> getAllTasks() throws SQLException {
        List<Task> taskList = new ArrayList<>();
        try (Connection connectDB = DriverManager.getConnection(url + db, user, password);
             PreparedStatement preparedStatement = connectDB.prepareStatement(SELECT_ALL_TASKS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Task task = new Task();
                int id = rs.getInt("id");
                String taskName = rs.getString("task_name");
                Boolean completed = rs.getBoolean("completed");
                task.setId(id);
                task.setTaskName(taskName);
                task.setCompleted(completed);
                taskList.add(task);
                System.out.println(id + " " + taskName + " " + completed);
            }
        }
        return taskList;
    }

}
