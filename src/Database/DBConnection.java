package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Students_details";
    private static final String USER = "root";
    private static final String PASS = "Prince@123";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
