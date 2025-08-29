package com.oriomri.taskmanager.dao;

import com.oriomri.taskmanager.model.ITask;
import com.oriomri.taskmanager.model.Task;
import com.oriomri.taskmanager.model.TaskState;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the Data Access Object for tasks.
 * This class implements the Singleton pattern to ensure only one instance
 * manages the database connection and provides CRUD operations for tasks.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class TasksDAO implements ITasksDAO {
    
    //private variables declaration
    private static TasksDAO instance;
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:derby:mydb;create=true";
    private static final String CREATE_TABLE_SQL = 
        "CREATE TABLE tasks (" +
        "id INT PRIMARY KEY, " +
        "title VARCHAR(255) NOT NULL, " +
        "description CLOB, " +
        "state VARCHAR(50) NOT NULL)";
    
    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the database connection and creates the tasks table if it doesn't exist.
     * 
     * @throws TaskManagerException if database initialization fails
     */
    private TasksDAO() throws TaskManagerException {
        initializeDatabase();
    }
    
    /**
     * Gets the single instance of TasksDAO (Singleton pattern).
     * Creates the instance if it doesn't exist.
     * 
     * @return the single TasksDAO instance
     * @throws TaskManagerException if instance creation fails
     */
    public static synchronized TasksDAO getInstance() throws TaskManagerException {
        if (instance == null) {
            instance = new TasksDAO();
        }
        return instance;
    }
    
    /**
     * Initializes the database connection and creates the tasks table.
     * 
     * @throws TaskManagerException if database initialization fails
     */
    private void initializeDatabase() throws TaskManagerException {
        try {
            //establish database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            
            //create tasks table if it doesn't exist
            createTasksTableIfNotExists();
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to initialize database", e);
        }
    }
    
    /**
     * Creates the tasks table if it doesn't exist in the database.
     * 
     * @throws TaskManagerException if table creation fails
     */
    private void createTasksTableIfNotExists() throws TaskManagerException {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "TASKS", null);
            
            if (!tables.next()) {
                //table doesn't exist, create it
                try (Statement statement = connection.createStatement()) {
                    statement.execute(CREATE_TABLE_SQL);
                }
            }
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to create tasks table", e);
        }
    }
    
    /**
     * Retrieves all tasks from the database.
     * 
     * @return an array of all tasks
     * @throws TaskManagerException if an error occurs during retrieval
     */
    @Override
    public ITask[] getTasks() throws TaskManagerException {
        List<ITask> tasks = new ArrayList<>();
        String sql = "SELECT id, title, description, state FROM tasks";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            //process each result row
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                TaskState state = TaskState.valueOf(resultSet.getString("state"));
                
                Task task = new Task(id, title, description, state);
                tasks.add(task);
            }
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to retrieve tasks", e);
        }
        
        return tasks.toArray(new ITask[0]);
    }
    
    /**
     * Retrieves a specific task by its ID.
     * 
     * @param id the unique identifier of the task to retrieve
     * @return the task with the specified ID, or null if not found
     * @throws TaskManagerException if an error occurs during retrieval
     */
    @Override
    public ITask getTask(int id) throws TaskManagerException {
        String sql = "SELECT id, title, description, state FROM tasks WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    TaskState state = TaskState.valueOf(resultSet.getString("state"));
                    
                    return new Task(id, title, description, state);
                }
            }
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to retrieve task with ID: " + id, e);
        }
        
        return null; //task not found
    }
    
    /**
     * Adds a new task to the database.
     * 
     * @param task the task to add
     * @throws TaskManagerException if an error occurs during addition
     */
    @Override
    public void addTask(ITask task) throws TaskManagerException {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        
        String sql = "INSERT INTO tasks (id, title, description, state) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, task.getId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getState().name());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to add task", e);
        }
    }
    
    /**
     * Updates an existing task in the database.
     * 
     * @param task the task to update
     * @throws TaskManagerException if an error occurs during update
     */
    @Override
    public void updateTask(ITask task) throws TaskManagerException {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        
        String sql = "UPDATE tasks SET title = ?, description = ?, state = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getState().name());
            statement.setInt(4, task.getId());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new TaskManagerException("Task with ID " + task.getId() + " not found for update");
            }
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to update task", e);
        }
    }
    
    /**
     * Deletes all tasks from the database.
     * 
     * @throws TaskManagerException if an error occurs during deletion
     */
    @Override
    public void deleteTasks() throws TaskManagerException {
        String sql = "DELETE FROM tasks";
        
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to delete all tasks", e);
        }
    }
    
    /**
     * Deletes a specific task by its ID.
     * 
     * @param id the unique identifier of the task to delete
     * @throws TaskManagerException if an error occurs during deletion
     */
    @Override
    public void deleteTask(int id) throws TaskManagerException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new TaskManagerException("Task with ID " + id + " not found for deletion");
            }
            
        } catch (SQLException e) {
            throw new TaskManagerException("Failed to delete task with ID: " + id, e);
        }
    }
    
    /**
     * Closes the database connection.
     * This method should be called when the application shuts down.
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //log the error but don't throw exception during shutdown
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}
