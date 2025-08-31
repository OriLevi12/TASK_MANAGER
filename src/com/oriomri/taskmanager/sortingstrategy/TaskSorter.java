package com.oriomri.taskmanager.sortingstrategy;

import com.oriomri.taskmanager.model.ITask;

/**
 * Context class that uses the Strategy pattern for sorting tasks.
 * This class can switch between different sorting strategies at runtime.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class TaskSorter {
    
    private ISortStrategy sortStrategy;
    
    /**
     * Default constructor that uses SortByIdStrategy as the default strategy.
     */
    public TaskSorter() {
        setSortStrategy(new SortByIdStrategy());
    }
    
    /**
     * Constructor that accepts a specific sorting strategy.
     * 
     * @param sortStrategy the sorting strategy to use
     */
    public TaskSorter(ISortStrategy sortStrategy) {
        setSortStrategy(sortStrategy);
    }
    
    /**
     * Sets the sorting strategy to use.
     * 
     * @param sortStrategy the new sorting strategy
     */
    public void setSortStrategy(ISortStrategy sortStrategy) {
        if (sortStrategy == null) {
            throw new IllegalArgumentException("Sort strategy cannot be null");
        }
        this.sortStrategy = sortStrategy;
    }
    
    /**
     * Gets the current sorting strategy.
     * 
     * @return the current sorting strategy
     */
    public ISortStrategy getSortStrategy() {
        return sortStrategy;
    }
    
    /**
     * Sorts tasks using the current sorting strategy.
     * 
     * @param tasks the array of tasks to sort
     * @return a new sorted array of tasks
     */
    public ITask[] sortTasks(ITask[] tasks) {
        return sortStrategy.sort(tasks);
    }
    
    /**
     * Gets the name of the current sorting strategy.
     * 
     * @return the name of the current strategy
     */
    public String getCurrentStrategyName() {
        return sortStrategy.getStrategyName();
    }
    
    /**
     * Convenience method to sort tasks by ID.
     * 
     * @param tasks the array of tasks to sort
     * @return a new array sorted by ID
     */
    public ITask[] sortById(ITask[] tasks) {
        ISortStrategy originalStrategy = this.sortStrategy;
        this.sortStrategy = new SortByIdStrategy();
        ITask[] result = sortTasks(tasks);
        this.sortStrategy = originalStrategy; // Restore original strategy
        return result;
    }
    
    /**
     * Convenience method to sort tasks by title.
     * 
     * @param tasks the array of tasks to sort
     * @return a new array sorted by title
     */
    public ITask[] sortByTitle(ITask[] tasks) {
        ISortStrategy originalStrategy = this.sortStrategy;
        this.sortStrategy = new SortByTitleStrategy();
        ITask[] result = sortTasks(tasks);
        this.sortStrategy = originalStrategy; // Restore original strategy
        return result;
    }
    
    /**
     * Convenience method to sort tasks by state.
     * 
     * @param tasks the array of tasks to sort
     * @return a new array sorted by state
     */
    public ITask[] sortByState(ITask[] tasks) {
        ISortStrategy originalStrategy = this.sortStrategy;
        this.sortStrategy = new SortByStateStrategy();
        ITask[] result = sortTasks(tasks);
        this.sortStrategy = originalStrategy; // Restore original strategy
        return result;
    }
}
