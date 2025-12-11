package Models;

public class Student {
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

    public Student(int rollNo, String name, String faculty, int age, long contactNum){
        this.rollNo = rollNo;
        this.name = name;
        this.faculty = faculty;
        this.age = age;
        this.contactNum = contactNum;
    }

    public int getId() { return id; }
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getFacualty() { return faculty; }
    public int getAge() { return age; }
    public long getContactNumber() { return contactNum; }

    public void setId(int id){ this.id = id; }
    public void setRollNo(int rollNo){ this.rollNo = rollNo; }
    public void setName(String name){ this.name = name; }
    public void setFacualty(String faculty){ this.faculty = faculty; }
    public void setAge(int age){ this.age = age; }
    public void setContactNumber(long contactNum){ this.contactNum = contactNum; }
    

    public void studentView(){
        System.out.println("\n\t\t\t\t Student View Details\n");
        System.out.println("Student ID: " + id);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + faculty);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNum);

    }
}
