import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ------------------------- ABSTRACT CLASS -------------------------
abstract class Person {
    protected String name;
    protected String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Abstract method
    public abstract void displayInfo();
}

// ------------------------- STUDENT CLASS -------------------------
class Student extends Person {
    private int rollNo;
    private String course;
    private int marks;
    private char grade;

    public Student(int rollNo, String name, String email, String course, int marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // Overloaded constructor (method overloading)
    public Student(int rollNo, String name, String email) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = "NA";
        this.marks = 0;
        this.grade = 'F';
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(int marks) {
        this.marks = marks;
        calculateGrade();
    }

    // Grade calculation
    private void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';
    }

    // Method Overriding
    @Override
    public void displayInfo() {
        System.out.println("-------------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Email   : " + email);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);
        System.out.println("Grade   : " + grade);
        System.out.println("-------------------------------");
    }
}

// ------------------------- INTERFACE -------------------------
interface RecordActions {
    void addStudent();
    void deleteStudent();
    void updateStudent();
    void viewStudents();
}

// ------------------------- STUDENT MANAGER -------------------------
class StudentManager implements RecordActions {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Check duplicate roll number
    private boolean rollExists(int roll) {
        for (Student s : students) {
            if (s.getRollNo() == roll) return true;
        }
        return false;
    }

    // Add Student (Implementation)
    public void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        if (rollExists(roll)) {
            System.out.println("Error: Roll number already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Marks (0-100): ");
        int marks = scanner.nextInt();

        Student s = new Student(roll, name, email, course, marks);
        students.add(s);

        System.out.println("Student added successfully!");
    }

    // Delete Student
    public void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = scanner.nextInt();

        Student temp = null;
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                temp = s;
                break;
            }
        }

        if (temp != null) {
            students.remove(temp);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Update Student
    public void updateStudent() {
        System.out.print("Enter Roll Number to update: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.print("Enter new course: ");
                String course = scanner.nextLine();

                System.out.print("Enter new marks: ");
                int marks = scanner.nextInt();

                s.setCourse(course);
                s.setMarks(marks);

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // View Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        for (Student s : students) {
            s.displayInfo();  // Polymorphism in action
        }
    }
}

// ------------------------- MAIN CLASS -------------------------
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> manager.deleteStudent();
                case 3 -> manager.updateStudent();
                case 4 -> manager.viewStudents();
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
