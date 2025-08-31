package com.oriomri.taskmanager.sortingstrategy;

import com.oriomri.taskmanager.model.ITask;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Concrete implementation of ISortStrategy that sorts tasks by their ID.
 * This strategy sorts tasks in ascending order by ID.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class SortByIdStrategy implements ISortStrategy {
    
    /**
     * Sorts tasks by ID in ascending order.
     * 
     * @param tasks the array of tasks to sort
     * @return a new sorted array of tasks
     */
    @Override
    public ITask[] sort(ITask[] tasks) {
        if (tasks == null) {
            return new ITask[0];
        }
        
        // Create a copy to avoid modifying the original array
        ITask[] sortedTasks = Arrays.copyOf(tasks, tasks.length);
        
        // Sort using Arrays.sort with a comparator
        Arrays.sort(sortedTasks, new Comparator<ITask>() {
            @Override
            public int compare(ITask task1, ITask task2) {
                return Integer.compare(task1.getId(), task2.getId());
            }
        });
        
        return sortedTasks;
    }
    
    /**
     * Gets the name of this sorting strategy.
     * 
     * @return the name of the strategy
     */
    @Override
    public String getStrategyName() {
        return "Sort by ID (Ascending)";
    }
}
