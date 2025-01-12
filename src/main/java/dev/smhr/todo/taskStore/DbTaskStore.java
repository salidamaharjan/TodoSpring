package dev.smhr.todo.taskStore;

import dev.smhr.todo.AddTask;
import dev.smhr.todo.DB_Connection;
import dev.smhr.todo.GetAllTasks;
import dev.smhr.todo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DbTaskStore implements TaskStoreInterface{
    @Autowired
   public DbTaskStore(){
        DB_Connection connectDB = new DB_Connection();
        try{
            connectDB.createTable();
        }catch(SQLException e){
            e.printStackTrace();
        };
    }
    @Override
    public List<Task> getTask() {
        GetAllTasks allTasks = new GetAllTasks();
        try {
           return allTasks.getAllTasks();
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

    }

    @Override
    public void deleteTask(int index) {

    }
}
