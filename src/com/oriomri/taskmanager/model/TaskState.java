package com.oriomri.taskmanager.model;

/**
 * Represents the different states a task can have in its lifecycle.
 * This enum follows the State pattern for task management.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public enum TaskState {
    
    /**
     * Task is created but not yet started.
     */
    TO_DO("To Do"),
    
    /**
     * Task is currently being worked on.
     */
    IN_PROGRESS("In Progress"),
    
    /**
     * Task has been completed.
     */
    COMPLETED("Completed");
    
    private final String displayName;
    
    /**
     * Constructs a TaskState with the specified display name.
     * 
     * @param displayName the human-readable name for this state
     */
    TaskState(String displayName) {
        this.displayName = displayName;
    }
    
    /**
     * Gets the display name for this task state.
     * 
     * @return the human-readable name
     */
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
