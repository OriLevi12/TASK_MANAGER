package com.oriomri.taskmanager.observer;

import com.oriomri.taskmanager.model.ITask;

/**
 * Interface for observers in the Observer pattern.
 * Classes implementing this interface will be notified when tasks change.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public interface ITaskObserver {
    
    /**
     * Called when a task is added to the system.
     * 
     * @param task the task that was added
     */
    void onTaskAdded(ITask task);
    
    /**
     * Called when a task is updated in the system.
     * 
     * @param task the task that was updated
     */
    void onTaskUpdated(ITask task);
    
    /**
     * Called when a task is deleted from the system.
     * 
     * @param taskId the ID of the task that was deleted
     */
    void onTaskDeleted(int taskId);
    
    /**
     * Called when all tasks are cleared from the system.
     */
    void onTasksCleared();
}
