package dev.smhr.todo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String db = "my_todo";
    private final String user = "myuser";
    private final String password = "secret";

    public void createTable() throws SQLException {
        String createTableSQL = """ 
                CREATE TABLE tasks(
                    id SERIAL PRIMARY KEY, 
                    task_name TEXT, 
                    completed BOOLEAN )
                """;
        try (Connection connection = DriverManager.getConnection(url+db, user, password);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'tasks' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
