package CMS1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

    static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    static final String USERNAME = "root";
    static final String PASSWORD = "abc123";

    public static void main(String[] args) {
        try {
            System.out.print("Connecting to database....");
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            System.out.println();

            if (connection != null) {
                System.out.println("Database connected successfully!");
                // Perform database operations here...
            }

            // Close the connection
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            System.out.println(exc);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
    
}
