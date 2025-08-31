package com.oriomri.taskmanager.exceptions;

/**
 * Custom exception for TaskManager operations.
 * This exception is thrown when task management operations fail.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class TaskManagerException extends Exception {
    
    /**
     * Constructs a TaskManagerException with the specified detail message.
     * 
     * @param message the detail message
     */
    public TaskManagerException(String message) {
        super(message);
    }
    
    /**
     * Constructs a TaskManagerException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public TaskManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
