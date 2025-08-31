package com.oriomri.taskmanager.sortingstrategy;

import com.oriomri.taskmanager.model.ITask;

/**
 * Interface for sorting strategies in the Strategy pattern.
 * Different implementations can provide different sorting algorithms for tasks.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public interface ISortStrategy {
    
    /**
     * Sorts an array of tasks according to the specific strategy.
     * 
     * @param tasks the array of tasks to sort
     * @return a new sorted array of tasks
     */
    ITask[] sort(ITask[] tasks);
    
    /**
     * Gets the name of this sorting strategy.
     * 
     * @return the name of the strategy
     */
    String getStrategyName();
}
