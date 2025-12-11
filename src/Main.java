import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Database.DBConnection;
import Models.Student;
import Models.StudentDAO;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Connection con = DBConnection.getConnection();
        try {
            if (con != null) {
                System.out.println("Connected to Database!");
            } else {
                System.out.println("Database Connection faild!");
            }
        } catch (Exception e) {
                System.out.println("");
        }
        
        while (true) {
            System.out.println("\n\t\t\t\t Home\n");
            System.out.println("1. Add Student");
            System.out.println("2. View Student Details");
            System.out.println("3. Update Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5 Exit\n");

            System.out.print("Enter your option: ");
            int selecte = sc.nextInt();

        switch (selecte) {
            case 1 -> {

                System.out.println("\n\t\t\t\t Add Student\n");
                System.out.println("Student ID: " + id);

                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                
                System.out.print("Enter Course: ");
                String faculty = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Contact Number: ");
                long contactNum = sc.nextLong(); 

                boolean ok = StudentDAO.addStudent (
                    new Student(id, roll, name, faculty, age, contactNum)

                );

                System.out.println(ok ? "Added!" : "Failed");
            }

            case 2 -> {
                System.out.println("\n\t\t\t\t View Student\n");
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                Student s = StudentDAO.getStudent(id);;
                if(s != null){
                    s.print;
                } else {
                    System.out.println("not found!");
                }

            }

            case 3 -> {
                System.out.println("\n\t\t\t\t Update Student\n");
                System.out.print("Enter Student ID: ");
                int id = StudentDAO.getStudent(id)
                sc.nextLine();

                Student s = StudentDAO.getStudent(id);
                if (s == null) {
                    System.out.println("Not found!");
                    break;
                }

                System.out.print("Enter new Roll No: ");
                s.setRollNo(sc.nextInt());
                sc.nextLine();
                    
                System.out.print("New Name: ");
                s.setName(sc.nextLine());

                System.out.print("New Faculty: ");
                s.setFacualty(sc.nextLine());

                System.out.print("New Age: ");
                s.setAge(sc.nextInt());

                System.out.print("New Contact: ");
                s.setContactNumber(sc.nextLong()); 

                System.out.println(StudentDAO.updateStudent(s) ? "Update" : "Failed!");

            }

            case 4 -> {
                System.out.println("\n\t\t\t\t Delete Student\n");
                System.out.print("Enter Student ID: ");
                int id =  sc.nextInt();

                System.out.println(StudentDAO.deleteStudent(id) ? "Delete" : "Failed!");
                continue;
            }

            case 5 -> {
                List<Student> all = StudentDAO.getAllStudent();
                all.forEach(Student::print);
            }     

            case 6 -> {
                System.out.println("Thankyou for use!");
                System.exit(0);
            }  
          }
        }
    }
}
