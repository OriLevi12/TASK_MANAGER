package com.oriomri.taskmanager.dao;

/**
 * Custom exception for Task Manager application.
 * This exception is thrown when errors occur during task operations.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class TaskManagerException extends Exception {
    
    /**
     * Constructs a new TaskManagerException with the specified detail message.
     * 
     * @param message the detail message
     */
    public TaskManagerException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new TaskManagerException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause (which is saved for later retrieval by the getCause() method)
     */
    public TaskManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
