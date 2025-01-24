import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Management System
 * 
 * This program manages a list of students, providing functionality to add,
 * display, search, and remove students by their unique ID.
 */
public class StudentManagementSystem {
    // Inner class representing a student
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

    // List to store student records
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addNewStudent(scanner);
                case 2 -> displayAllStudents();
                case 3 -> searchStudentById(scanner);
                case 4 -> removeStudentById(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    /**
     * Adds a new student to the system.
     * Checks for duplicate IDs before adding.
     * 
     * @param scanner Scanner object for user input.
     */
    static void addNewStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        // Check if the ID already exists in the list
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Error: A student with ID " + id + " already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    /**
     * Displays all students in a formatted table.
     * If no students are present, an appropriate message is displayed.
     */
    static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        System.out.printf("%-10s %-20s %-5s%n", "ID", "Name", "Age");
        System.out.println("------------------------------------");
        for (Student student : students) {
            System.out.printf("%-10d %-20s %-5d%n", student.id, student.name, student.age);
        }
    }

    /**
     * Searches for a student by their ID.
     * Displays the student's details if found.
     * 
     * @param scanner Scanner object for user input.
     */
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

    /**
     * Removes a student by their ID.
     * Displays an error message if the student is not found.
     * 
     * @param scanner Scanner object for user input.
     */
    static void removeStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student with ID " + id + " removed successfully!");
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }
}
