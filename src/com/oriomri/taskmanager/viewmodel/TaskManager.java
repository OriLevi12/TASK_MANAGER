package com.oriomri.taskmanager.viewmodel;

import com.oriomri.taskmanager.dao.ITasksDAO;
import com.oriomri.taskmanager.dao.TasksDAO;
import com.oriomri.taskmanager.model.ITask;
import com.oriomri.taskmanager.observer.ITaskObserver;
import com.oriomri.taskmanager.observer.ITaskSubject;
import com.oriomri.taskmanager.exceptions.TaskManagerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Main task manager class that implements the Observer pattern.
 * This class manages tasks and notifies observers when changes occur.
 * It acts as the central point for task operations in the MVVM architecture.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class TaskManager implements ITaskSubject {
    
    private final ITasksDAO tasksDAO;
    private final List<ITaskObserver> observers;
    
    /**
     * Constructor for TaskManager.
     * Initializes the DAO and observer list.
     * 
     * @throws TaskManagerException if initialization fails
     */
    public TaskManager() throws TaskManagerException {
        this.tasksDAO = TasksDAO.getInstance();
        this.observers = new ArrayList<>();
    }
    
    /**
     * Registers an observer to receive task change notifications.
     * 
     * @param observer the observer to register
     */
    @Override
    public void registerObserver(ITaskObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    /**
     * Unregisters an observer from receiving task change notifications.
     * 
     * @param observer the observer to unregister
     */
    @Override
    public void unregisterObserver(ITaskObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }
    
    /**
     * Notifies all registered observers about a task being added.
     * 
     * @param task the task that was added
     */
    @Override
    public void notifyTaskAdded(ITask task) {
        for (ITaskObserver observer : observers) {
            observer.onTaskAdded(task);
        }
    }
    
    /**
     * Notifies all registered observers about a task being updated.
     * 
     * @param task the task that was updated
     */
    @Override
    public void notifyTaskUpdated(ITask task) {
        for (ITaskObserver observer : observers) {
            observer.onTaskUpdated(task);
        }
    }
    
    /**
     * Notifies all registered observers about a task being deleted.
     * 
     * @param taskId the ID of the task that was deleted
     */
    @Override
    public void notifyTaskDeleted(int taskId) {
        for (ITaskObserver observer : observers) {
            observer.onTaskDeleted(taskId);
        }
    }
    
    /**
     * Notifies all registered observers that all tasks were cleared.
     */
    @Override
    public void notifyTasksCleared() {
        for (ITaskObserver observer : observers) {
            observer.onTasksCleared();
        }
    }
    
    /**
     * Adds a new task to the system and notifies observers.
     * 
     * @param task the task to add
     * @throws TaskManagerException if adding the task fails
     */
    public void addTask(ITask task) throws TaskManagerException {
        tasksDAO.addTask(task);
        notifyTaskAdded(task);
    }
    
    /**
     * Updates an existing task in the system and notifies observers.
     * 
     * @param task the task to update
     * @throws TaskManagerException if updating the task fails
     */
    public void updateTask(ITask task) throws TaskManagerException {
        tasksDAO.updateTask(task);
        notifyTaskUpdated(task);
    }
    
    /**
     * Deletes a task from the system and notifies observers.
     * 
     * @param taskId the ID of the task to delete
     * @throws TaskManagerException if deleting the task fails
     */
    public void deleteTask(int taskId) throws TaskManagerException {
        tasksDAO.deleteTask(taskId);
        notifyTaskDeleted(taskId);
    }
    
    /**
     * Deletes all tasks from the system and notifies observers.
     * 
     * @throws TaskManagerException if clearing tasks fails
     */
    public void deleteAllTasks() throws TaskManagerException {
        tasksDAO.deleteTasks();
        notifyTasksCleared();
    }
    
    /**
     * Retrieves all tasks from the system.
     * 
     * @return an array of all tasks
     * @throws TaskManagerException if retrieving tasks fails
     */
    public ITask[] getAllTasks() throws TaskManagerException {
        return tasksDAO.getTasks();
    }
    
    /**
     * Retrieves a specific task by ID.
     * 
     * @param taskId the ID of the task to retrieve
     * @return the task with the specified ID, or null if not found
     * @throws TaskManagerException if retrieving the task fails
     */
    public ITask getTask(int taskId) throws TaskManagerException {
        return tasksDAO.getTask(taskId);
    }
    
    /**
     * Gets the number of registered observers.
     * 
     * @return the number of observers
     */
    public int getObserverCount() {
        return observers.size();
    }
}
