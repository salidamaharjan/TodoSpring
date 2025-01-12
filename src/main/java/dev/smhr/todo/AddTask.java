package dev.smhr.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTask {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    private static final String INSERT_TASKS_SQL = "INSERT INTO tasks" +
            "  (task_name, completed) VALUES " +
            " (?, ?);";

    public void addTask(String taskName) {
        try {
            Connection connectDB = DriverManager.getConnection(url + db, user, password);
            PreparedStatement preparedStatement = connectDB.prepareStatement(INSERT_TASKS_SQL);
            preparedStatement.setString(1, taskName);
            preparedStatement.setBoolean(2, false);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
