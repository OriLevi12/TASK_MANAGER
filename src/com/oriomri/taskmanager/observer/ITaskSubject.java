package com.oriomri.taskmanager.observer;

import com.oriomri.taskmanager.model.ITask;

/**
 * Interface for subjects in the Observer pattern.
 * Classes implementing this interface can register and notify observers.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public interface ITaskSubject {
    
    /**
     * Registers an observer to receive notifications.
     * 
     * @param observer the observer to register
     */
    void registerObserver(ITaskObserver observer);
    
    /**
     * Unregisters an observer from receiving notifications.
     * 
     * @param observer the observer to unregister
     */
    void unregisterObserver(ITaskObserver observer);
    
    /**
     * Notifies all registered observers about a task being added.
     * 
     * @param task the task that was added
     */
    void notifyTaskAdded(ITask task);
    
    /**
     * Notifies all registered observers about a task being updated.
     * 
     * @param task the task that was updated
     */
    void notifyTaskUpdated(ITask task);
    
    /**
     * Notifies all registered observers about a task being deleted.
     * 
     * @param taskId the ID of the task that was deleted
     */
    void notifyTaskDeleted(int taskId);
    
    /**
     * Notifies all registered observers that all tasks were cleared.
     */
    void notifyTasksCleared();
}
