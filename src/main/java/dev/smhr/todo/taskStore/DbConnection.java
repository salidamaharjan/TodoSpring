package dev.smhr.todo.taskStore;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DbConnection {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    public Connection getConnection()throws SQLException{
        Connection connection = DriverManager.getConnection(url + db, user, password);
        return connection;
    }

    public void createTable() throws SQLException {
        String createTableSQL = """ 
                CREATE TABLE IF NOT EXISTS tasks(
                    id SERIAL PRIMARY KEY, 
                    task_name TEXT, 
                    completed BOOLEAN )
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'tasks' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
