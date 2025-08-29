import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Derby connection test...");
        
        // Check if the Derby driver is available
        System.out.println("Available drivers:");
        Driver[] drivers = DriverManager.drivers().toArray(Driver[]::new);
        for (Driver driver : drivers) {
            System.out.println("  " + driver.getClass().getName());
        }
        
        // Try to connect directly (modern JDBC should auto-load the driver)
        try (Connection conn = DriverManager.getConnection("jdbc:derby:mydb;create=true")) {
            System.out.println("Connected to Derby!");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
