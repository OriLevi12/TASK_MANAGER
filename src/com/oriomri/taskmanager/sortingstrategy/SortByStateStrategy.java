package com.oriomri.taskmanager.sortingstrategy;

import com.oriomri.taskmanager.model.ITask;
import com.oriomri.taskmanager.model.TaskState;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Concrete implementation of ISortStrategy that sorts tasks by their state.
 * This strategy sorts tasks in a logical order: TO_DO, IN_PROGRESS, COMPLETED.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class SortByStateStrategy implements ISortStrategy {
    
    /**
     * Sorts tasks by state in logical order: TO_DO, IN_PROGRESS, COMPLETED.
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
        
        // Sort using Arrays.sort with a comparator for state
        Arrays.sort(sortedTasks, new Comparator<ITask>() {
            @Override
            public int compare(ITask task1, ITask task2) {
                TaskState state1 = task1.getState();
                TaskState state2 = task2.getState();
                
                // Handle null states safely
                if (state1 == null && state2 == null) {
                    return 0;
                }
                if (state1 == null) {
                    return -1; // null states come first
                }
                if (state2 == null) {
                    return 1;  // null states come first
                }
                
                // Define the logical order of states
                int order1 = getStateOrder(state1);
                int order2 = getStateOrder(state2);
                
                // Compare by order (lower order comes first)
                return Integer.compare(order1, order2);
            }
        });
        
        return sortedTasks;
    }
    
    /**
     * Gets the priority order for a task state.
     * Lower numbers come first in the sort order.
     * 
     * @param state the task state
     * @return the priority order (0 = highest priority, 2 = lowest priority)
     */
    private int getStateOrder(TaskState state) {
        switch (state) {
            case TO_DO:
                return 0;      // Highest priority - comes first
            case IN_PROGRESS:
                return 1;      // Medium priority - comes second
            case COMPLETED:
                return 2;      // Lowest priority - comes last
            default:
                return 999;    // Unknown states come last
        }
    }
    
    /**
     * Gets the name of this sorting strategy.
     * 
     * @return the name of the strategy
     */
    @Override
    public String getStrategyName() {
        return "Sort by State (To Do → In Progress → Completed)";
    }
}
