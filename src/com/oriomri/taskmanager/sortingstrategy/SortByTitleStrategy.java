package com.oriomri.taskmanager.sortingstrategy;

import com.oriomri.taskmanager.model.ITask;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Concrete implementation of ISortStrategy that sorts tasks by their title.
 * This strategy sorts tasks alphabetically by title in ascending order.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class SortByTitleStrategy implements ISortStrategy {
    
    /**
     * Sorts tasks alphabetically by title in ascending order.
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
        
        // Sort using Arrays.sort with a comparator for title
        Arrays.sort(sortedTasks, new Comparator<ITask>() {
            @Override
            public int compare(ITask task1, ITask task2) {
                String title1 = task1.getTitle();
                String title2 = task2.getTitle();
                
                // Handle null titles safely
                if (title1 == null && title2 == null) {
                    return 0;
                }
                if (title1 == null) {
                    return -1; // null titles come first
                }
                if (title2 == null) {
                    return 1;  // null titles come first
                }
                
                // Compare titles alphabetically (case-insensitive)
                return title1.compareToIgnoreCase(title2);
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
        return "Sort by Title (A-Z)";
    }
}
