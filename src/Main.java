import java.util.List;
import java.util.Scanner;

import Models.Student;
import Models.StudentDAO;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (Models.StudentDAO.getAllStudents() != null) {
            System.out.println("DB check done.");
        }

        while (true) {
            System.out.println("\n\t\t\t\t Home\n");
            System.out.println("1. Add Student");
            System.out.println("2. View Student Details");
            System.out.println("3. Update Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit\n");

            System.out.print("Enter your option: ");
            int selected = -1;
            try {
                selected = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (selected) {
                case 1 -> { 
                    try {
                        System.out.println("\n\t\t\t\t Add Student\n");

                        System.out.print("Enter Roll No: ");
                        int roll = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter Faculty: ");
                        String faculty = sc.nextLine().trim();

                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter Contact Number: ");
                        long contactNum = Long.parseLong(sc.nextLine().trim());

                        Student s = new Student(roll, name, faculty, age, contactNum);
                        boolean ok = StudentDAO.addStudent(s);

                        System.out.println(ok ? "Added!" : "Failed to add student.");
                    } catch (Exception ex) {
                        System.out.println("Input error: " + ex.getMessage());
                    }
                }

                case 2 -> { 
                    System.out.println("\n\t\t\t\t View Student\n");
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Student s = StudentDAO.getStudent(id);
                    if (s != null) {
                        s.studentView();
                    } else {
                        System.out.println("Not found!");
                    }
                }

                case 3 -> {
                    System.out.println("\n\t\t\t\t Update Student\n");
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());

                    Student s = StudentDAO.getStudent(id);
                    if (s == null) {
                        System.out.println("Not found!");
                        break;
                    }

                    System.out.print("Enter new Roll No: ");
                    s.setRollNo(Integer.parseInt(sc.nextLine().trim()));

                    System.out.print("New Name: ");
                    s.setName(sc.nextLine().trim());

                    System.out.print("New Faculty: ");
                    s.setFaculty(sc.nextLine().trim());

                    System.out.print("New Age: ");
                    s.setAge(Integer.parseInt(sc.nextLine().trim()));

                    System.out.print("New Contact: ");
                    s.setContactNumber(Long.parseLong(sc.nextLine().trim()));

                    System.out.println(StudentDAO.updateStudent(s) ? "Updated!" : "Failed!");
                }

                case 4 -> { 
                    System.out.println("\n\t\t\t\t Delete Student\n");
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    System.out.println(StudentDAO.deleteStudent(id) ? "Deleted!" : "Failed!");
                }

                case 5 -> { 
                    List<Student> all = StudentDAO.getAllStudents();
                    if (all.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        all.forEach(Student::studentView);
                    }
                }

                case 6 -> { 
                    System.out.println("Thank you for using!");
                    sc.close();
                    System.exit(0);
                }

                default -> {
                    System.out.println("Invalid option. Try again.");
                }
            } 
        } 
    }
}
