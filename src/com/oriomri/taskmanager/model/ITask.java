package com.oriomri.taskmanager.model;

/**
 * Interface representing a task in the task management system.
 * This interface defines the contract for all task objects and includes
 * the accept method for implementing the Visitor pattern.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public interface ITask {
    
    /**
     * Gets the unique identifier of the task.
     * 
     * @return the task ID as an integer
     */
    int getId();
    
    /**
     * Gets the title of the task.
     * 
     * @return the task title as a string
     */
    String getTitle();
    
    /**
     * Gets the description of the task.
     * 
     * @return the task description as a string
     */
    String getDescription();
    
    /**
     * Gets the current state of the task.
     * 
     * @return the current TaskState of the task
     */
    TaskState getState();
    
    /**
     * Accepts a visitor for implementing the Visitor pattern.
     * This method allows external operations to be performed on the task
     * without modifying the task class itself.
     * 
     * @param visitor the TaskVisitor to accept
     */
    void accept(TaskVisitor visitor);
}
