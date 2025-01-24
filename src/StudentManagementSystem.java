import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> displayStudents();
                case 3 -> searchStudentById(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Student Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Name: " + student.name + ", Age: " + student.age);
        }
    }

    static void searchStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.id == id) {
                System.out.println("ID: " + student.id + ", Name: " + student.name + ", Age: " + student.age);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}