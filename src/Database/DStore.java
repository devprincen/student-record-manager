package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DStore {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Students_details";
    private static final String USER = "root";
    private static final String PASS = "Prince@123";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASS);

        } catch (ClassNotFoundException e) {
            System.out.println("MySql Driver not found!");
            e.printStackTrace();

        } catch (SQLException e){
            System.out.println("Database not found!");
            e.printStackTrace();
        }
        return null;
    }
    
}
