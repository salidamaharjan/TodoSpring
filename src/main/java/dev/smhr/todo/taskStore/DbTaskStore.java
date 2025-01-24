package dev.smhr.todo.taskStore;

import dev.smhr.todo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


        AddTask aTask = new AddTask();
        aTask.addTask(task.getTaskName());
    }

    @Override
    public void editTask(Integer index, Task updateTask) {
        EditTask editTask = new EditTask();
        editTask.editTask(index, updateTask);
    }

    @Override
    public void deleteTask(Integer id) {
    DeleteTask deleteTask = new DeleteTask();
    deleteTask.deleteTask(id);
    }
}
