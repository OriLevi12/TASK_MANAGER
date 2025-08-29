package com.oriomri.taskmanager.model;

/**
 * Concrete implementation of a task in the task management system.
 * This class represents a task with an ID, title, description, and state.
 * It implements the ITask interface and follows the State pattern.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class Task implements ITask {
    
    //private variables declaration
    private int id;
    private String title;
    private String description;
    private TaskState state;
    
    /**
     * Primary constructor for creating a task with all properties.
     * 
     * @param id the unique identifier for the task
     * @param title the title of the task
     * @param description the description of the task
     * @param state the initial state of the task
     */
    public Task(int id, String title, String description, TaskState state) {
        setId(id);
        setTitle(title);
        setDescription(description);
        setState(state);
    }
    
    /**
     * Constructor for creating a task with default state TO_DO.
     * 
     * @param id the unique identifier for the task
     * @param title the title of the task
     * @param description the description of the task
     */
    public Task(int id, String title, String description) {
        this(id, title, description, TaskState.TO_DO);
    }
    
    /**
     * Gets the unique identifier of the task.
     * 
     * @return the task ID as an integer
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier of the task.
     * 
     * @param id the task ID to set
     */
    public void setId(int id) {
        //validation test inside setter
        if (id < 0) {
            throw new IllegalArgumentException("Task ID cannot be negative");
        }
        this.id = id;
    }
    
    /**
     * Gets the title of the task.
     * 
     * @return the task title as a string
     */
    @Override
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title of the task.
     * 
     * @param title the task title to set
     */
    public void setTitle(String title) {
        //validation test inside setter
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        this.title = title.trim();
    }
    
    /**
     * Gets the description of the task.
     * 
     * @return the task description as a string
     */
    @Override
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the description of the task.
     * 
     * @param description the task description to set
     */
    public void setDescription(String description) {
        //validation test inside setter
        if (description == null) {
            throw new IllegalArgumentException("Task description cannot be null");
        }
        this.description = description;
    }
    
    /**
     * Gets the current state of the task.
     * 
     * @return the current TaskState of the task
     */
    @Override
    public TaskState getState() {
        return state;
    }
    
    /**
     * Sets the state of the task.
     * 
     * @param state the task state to set
     */
    public void setState(TaskState state) {
        //validation test inside setter
        if (state == null) {
            throw new IllegalArgumentException("Task state cannot be null");
        }
        this.state = state;
    }
    
    /**
     * Accepts a visitor for implementing the Visitor pattern.
     * This method allows external operations to be performed on the task
     * without modifying the task class itself.
     * 
     * @param visitor the TaskVisitor to accept
     */
    @Override
    public void accept(TaskVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor cannot be null");
        }
        visitor.visit(this);
    }
    
    /**
     * Checks if this task is equal to another object.
     * Two tasks are equal if they have the same ID.
     * 
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        return id == other.id;
    }
    
    /**
     * Generates a hash code for this task based on its ID.
     * 
     * @return the hash code for this task
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
    /**
     * Returns a string representation of this task.
     * 
     * @return a string containing the task information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task{")
          .append("id=").append(id)
          .append(", title='").append(title).append('\'')
          .append(", description='").append(description).append('\'')
          .append(", state=").append(state)
          .append('}');
        return sb.toString();
    }
}
