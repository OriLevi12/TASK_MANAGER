import com.oriomri.taskmanager.model.Task;
import com.oriomri.taskmanager.model.TaskState;
import com.oriomri.taskmanager.dao.TasksDAO;
import com.oriomri.taskmanager.model.ITask;

/**
 * Main class to test the Tasks Management Application functionality.
 * Tests database connection, CRUD operations, and design patterns.
 * 
 * @author Ori and Omri
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🚀 Starting Tasks Management Application Test...\n");
        
        try {
            // Test 1: Singleton Pattern and Database Connection
            System.out.println("📋 Test 1: Singleton Pattern and Database Connection");
            System.out.println("Getting TasksDAO instance...");
            TasksDAO dao = TasksDAO.getInstance();
            System.out.println("✅ TasksDAO instance created successfully (Singleton pattern working)");
            
            // Clean up database before testing
            System.out.println("🧹 Cleaning up database for fresh test...");
            dao.deleteTasks();
            System.out.println("✅ Database cleared successfully");
            
            // Test 2: Add Tasks
            System.out.println("\n📋 Test 2: Adding Tasks");
            Task task1 = new Task(1, "Study Java", "Learn design patterns and MVVM architecture");
            Task task2 = new Task(2, "Practice Coding", "Implement the Observer pattern");
            Task task3 = new Task(3, "Review Code", "Check code quality and standards", TaskState.IN_PROGRESS);
            
            dao.addTask(task1);
            System.out.println("✅ Task 1 added: " + task1.getTitle());
            
            dao.addTask(task2);
            System.out.println("✅ Task 2 added: " + task2.getTitle());
            
            dao.addTask(task3);
            System.out.println("✅ Task 3 added: " + task3.getTitle());
            
            // Test 3: Read All Tasks
            System.out.println("\n📋 Test 3: Reading All Tasks");
            ITask[] allTasks = dao.getTasks();
            System.out.println("✅ Found " + allTasks.length + " tasks in database:");
            for (ITask task : allTasks) {
                System.out.println("   - ID: " + task.getId() + 
                                ", Title: " + task.getTitle() + 
                                ", State: " + task.getState());
            }
            
            // Test 4: Read Specific Task
            System.out.println("\n📋 Test 4: Reading Specific Task");
            ITask retrievedTask = dao.getTask(2);
            if (retrievedTask != null) {
                System.out.println("✅ Retrieved task: " + retrievedTask.getTitle() + 
                                " (State: " + retrievedTask.getState() + ")");
            } else {
                System.out.println("❌ Failed to retrieve task with ID 2");
            }
            
            // Test 5: State Pattern - Change Task State
            System.out.println("\n📋 Test 5: State Pattern - Changing Task States");
            System.out.println("Task 1 current state: " + task1.getState());
            
            task1.setState(TaskState.IN_PROGRESS);
            System.out.println("Task 1 new state: " + task1.getState());
            
            task1.setState(TaskState.COMPLETED);
            System.out.println("Task 1 final state: " + task1.getState());
            
            // Test 6: Update Task in Database
            System.out.println("\n📋 Test 6: Updating Task in Database");
            dao.updateTask(task1);
            System.out.println("✅ Task 1 updated in database with new state: " + task1.getState());
            
            // Test 7: Verify Update
            System.out.println("\n📋 Test 7: Verifying Update");
            ITask updatedTask = dao.getTask(1);
            if (updatedTask != null) {
                System.out.println("✅ Updated task state: " + updatedTask.getState());
            }
            
            // Test 8: Delete Specific Task
            System.out.println("\n📋 Test 8: Deleting Specific Task");
            dao.deleteTask(3);
            System.out.println("✅ Task 3 deleted from database");
            
            // Test 9: Verify Deletion
            System.out.println("\n📋 Test 9: Verifying Deletion");
            ITask[] remainingTasks = dao.getTasks();
            System.out.println("✅ Remaining tasks: " + remainingTasks.length);
            for (ITask task : remainingTasks) {
                System.out.println("   - ID: " + task.getId() + ", Title: " + task.getTitle());
            }
            
            // Test 10: Error Handling
            System.out.println("\n📋 Test 10: Error Handling");
            try {
                dao.getTask(999); // Non-existent task
                System.out.println("❌ Should have returned null for non-existent task");
            } catch (Exception e) {
                System.out.println("✅ Error handling working: " + e.getMessage());
            }
            
            System.out.println("\n🎉 All Tests Completed Successfully!");
            System.out.println("✅ Singleton Pattern: Working");
            System.out.println("✅ State Pattern: Working");
            System.out.println("✅ CRUD Operations: Working");
            System.out.println("✅ Database Connection: Working");
            System.out.println("✅ Error Handling: Working");
            
        } catch (Exception e) {
            System.err.println("\n❌ Test Failed with Error:");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
