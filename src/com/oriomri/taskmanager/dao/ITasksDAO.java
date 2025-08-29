package com.oriomri.taskmanager.dao;

import com.oriomri.taskmanager.model.ITask;

/**
 * Interface for Data Access Object operations on tasks.
 * This interface defines the contract for all database operations
 * related to tasks and will be implemented as a Singleton.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public interface ITasksDAO {
    
    /**
     * Retrieves all tasks from the database.
     * 
     * @return an array of all tasks
     * @throws TaskManagerException if an error occurs during retrieval
     */
    ITask[] getTasks() throws TaskManagerException;
    
    /**
     * Retrieves a specific task by its ID.
     * 
     * @param id the unique identifier of the task to retrieve
     * @return the task with the specified ID, or null if not found
     * @throws TaskManagerException if an error occurs during retrieval
     */
    ITask getTask(int id) throws TaskManagerException;
    
    /**
     * Adds a new task to the database.
     * 
     * @param task the task to add
     * @throws TaskManagerException if an error occurs during addition
     */
    void addTask(ITask task) throws TaskManagerException;
    
    /**
     * Updates an existing task in the database.
     * 
     * @param task the task to update
     * @throws TaskManagerException if an error occurs during update
     */
    void updateTask(ITask task) throws TaskManagerException;
    
    /**
     * Deletes all tasks from the database.
     * 
     * @throws TaskManagerException if an error occurs during deletion
     */
    void deleteTasks() throws TaskManagerException;
    
    /**
     * Deletes a specific task by its ID.
     * 
     * @param id the unique identifier of the task to delete
     * @throws TaskManagerException if an error occurs during deletion
     */
    void deleteTask(int id) throws TaskManagerException;
}
