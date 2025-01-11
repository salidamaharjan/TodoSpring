package dev.smhr.todo.taskStore;

import dev.smhr.todo.DB_Connection;
import dev.smhr.todo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return List.of();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void editTask(Integer index, Task updateTask) {

    }

    @Override
    public void deleteTask(int index) {

    }
}
