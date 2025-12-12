package Models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnection;

public class StudentDAO {

    public static boolean addStudent(Student s) {
        String query = "INSERT INTO students (roll_no, name, faculty, age, contact_num) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                System.err.println("No DB connection available.");
                return false;
            }
            try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, s.getRollNo());
                ps.setString(2, s.getName());
                ps.setString(3, s.getFaculty());
                ps.setInt(4, s.getAge());
                ps.setLong(5, s.getContactNumber());

                int affected = ps.executeUpdate();
                if (affected == 0) return false;

                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        s.setId(keys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Add Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static Student getStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return null;
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Student(
                                rs.getInt("id"),
                                rs.getInt("roll_no"),
                                rs.getString("name"),
                                rs.getString("faculty"),
                                rs.getInt("age"),
                                rs.getLong("contact_num")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Get Error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateStudent(Student s) {
        String query = "UPDATE students SET roll_no = ?, name = ?, faculty = ?, age = ?, contact_num = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return false;
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, s.getRollNo());
                ps.setString(2, s.getName());
                ps.setString(3, s.getFaculty());
                ps.setInt(4, s.getAge());
                ps.setLong(5, s.getContactNumber());
                ps.setInt(6, s.getId());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return false;
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return list;
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    Student s = new Student(
                            rs.getInt("id"),
                            rs.getInt("roll_no"),
                            rs.getString("name"),
                            rs.getString("faculty"),
                            rs.getInt("age"),
                            rs.getLong("contact_num")
                    );
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            System.err.println("Get All Error: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
