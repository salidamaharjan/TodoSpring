package dev.smhr.todo.taskStore;

import dev.smhr.todo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbTaskStore implements TaskStoreInterface{
    private DbConnection connectDB;
    private static final String SELECT_ALL_TASKS = "SELECT * FROM tasks order by id";
    private static final String INSERT_TASKS_SQL = """
                        INSERT INTO tasks
                        (task_name, completed) VALUES 
                        (?, ?)
            """;
    private static final String UPDATE_TASK_SQL = "UPDATE tasks SET task_name = ? WHERE id = ?;";
    private final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE id =?;";

    @Autowired
   public DbTaskStore(){
        connectDB = new DbConnection();
        try{
            connectDB.createTable();
        }catch(SQLException e){
            e.printStackTrace();
        };
    }
    @Override
    public List<Task> getTask() {
        List<Task> taskList = new ArrayList<>();
        try(Connection connection = connectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);
            ResultSet rs = preparedStatement.executeQuery()
        ) {
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
            return taskList;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addTask(Task task) {
        try {
            Connection connection = connectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL);
            preparedStatement.setString(1,task.getTaskName() );
            preparedStatement.setBoolean(2, false);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(Integer index, Task updateTask) {
        try {
            Connection connection = connectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL);
            preparedStatement.setString(1, updateTask.getTaskName());
            preparedStatement.setInt(2, index);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(Integer id) {
        try {
            Connection connection = connectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TASK_SQL);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Deleted " + rows + " row(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
