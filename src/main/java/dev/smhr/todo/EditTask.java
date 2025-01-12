package dev.smhr.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditTask {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    private static final String UPDATE_TASK_SQL = "UPDATE tasks SET task_name = ? WHERE id = ?;";

    public void editTask(int id, Task newTask) {
        try {
            Connection connectDB = DriverManager.getConnection(url + db, user, password);
            PreparedStatement preparedStatement = connectDB.prepareStatement(UPDATE_TASK_SQL);
            preparedStatement.setString(1, newTask.getTaskName());
            preparedStatement.setInt(2, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
