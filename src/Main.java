import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    int rollNo;
    String name;
    String faculty;
    int age;
    long contactNum;

    public Student(int id, int rollNo, String name, String faculty, int age, long contatcNum){
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.faculty = faculty; 
        this.age = age;
        this.contactNum = contatcNum;
    }

    void studentView(){
        System.out.println("\n\t\t\t\t Student View Details\n");
        System.out.println("Student ID: " + id);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + faculty);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNum);

    }

    void UpdateStudent(int rollNo, String name, String faculty, int age, long contatcNum){
        this.rollNo = rollNo;
        this.name = name;
        this.faculty = faculty; 
        this.age = age;
        this.contactNum = contatcNum;

    }

}

public class Main {

        private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        int nextId = 1;
        Connecion con = DStore.getconnectiom();
        
        Scanner sc = new Scanner(System.in);
        
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
                System.out.println("Student ID: " + nextId);

                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                
                System.out.print("Enter Course: ");
                String facul = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Contact Number: ");
                long contact = sc.nextLong(); 

                Student s = new Student(nextId, roll, name, facul, age, contact);
                students.add(s);
                nextId++;


                System.out.println("Student Added Successfully!");
                continue;
            }

            case 2 -> {
                System.out.println("\n\t\t\t\t View Student\n");
                System.out.print("Enter Student ID: ");
                int checkId = sc.nextInt();
                boolean found = false;

                for(Student st : students){
                    if(st.id == checkId){
                        found = true;
                        st.studentView();
                        break;
                    }
                }
                if(!found){
                    System.out.println("Student not found into the list!");
                }
                continue;
            }

            case 3 -> {
                System.out.println("\n\t\t\t\t Update Student\n");
                System.out.print("Enter Student ID: ");
                int upCheck =  sc.nextInt();
                boolean found = false;

                for(Student su : students){
                    if(upCheck == su.id){
                        found = true;

                        System.out.print("Enter new Roll No: ");
                        int newRoll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        
                        System.out.print("Enter new Course: ");
                        String newFacul = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int newAge = sc.nextInt();

                        System.out.print("Enter New Contact No: ");
                        long newContact = sc.nextLong();

                        su.UpdateStudent(newRoll, newName, newFacul, newAge, newContact);
                        su.studentView();

                        System.out.println("Student Update Successfully!");

                    }

                }                  
                   if (!found){
                    System.out.println("Student not found into the list!");
                    }
                continue;
            }

            case 4 -> {
                System.out.println("\n\t\t\t\t Delete Student\n");
                System.out.print("Enter Student ID: ");
                int dsCheck =  sc.nextInt();

                boolean found = students.removeIf(s -> s.id == dsCheck);

                if(found){
                    System.out.println("Student Delete succesfully!");
                } else {
                    System.out.println("Student not found!");
                }
                continue;
            }

            case 5 -> {
                System.out.println("Thank you for use!");
                    System.exit(0);
            }       
          }
        sc.close();
        }
    }
}
