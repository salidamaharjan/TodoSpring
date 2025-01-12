package dev.smhr.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTask {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    private final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE id =?;";

    public void deleteTask(Integer id) {
        try {
            Connection connectDB = DriverManager.getConnection(url + db, user, password);
            PreparedStatement preparedStatement = connectDB.prepareStatement(DELETE_TASK_SQL);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Deleted " + rows + " row(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
