import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class StudentManagementSystemTest {

    private StudentManagementSystem system;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        system = new StudentManagementSystem();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to capture output
    }

    @Test
    void testAddNewStudent() {
        // TC1: Add a student
        Scanner scanner = new Scanner("101\nAlice\n20\n");
        system.addNewStudent(scanner);
        assertTrue(outputStream.toString().contains("Student added successfully!"));
    }

    @Test
    void testAddDuplicateStudent() {
        // TC2: Add a duplicate student ID
        Scanner scanner1 = new Scanner("101\nAlice\n20\n");
        system.addNewStudent(scanner1); // Add first student
        outputStream.reset(); // Clear the output

        Scanner scanner2 = new Scanner("101\nBob\n22\n");
        system.addNewStudent(scanner2); // Attempt to add duplicate ID
        assertTrue(outputStream.toString().contains("Error: A student with ID 101 already exists."));
    }

    @Test
    void testDisplayAllStudentsNonEmpty() {
        // TC3: Display all students (non-empty)
        Scanner scanner = new Scanner("101\nAlice\n20\n");
        system.addNewStudent(scanner); // Add a student
        outputStream.reset(); // Clear the output

        system.displayAllStudents();
        String output = outputStream.toString();
        assertTrue(output.contains("ID") && output.contains("Name") && output.contains("Age"));
        assertTrue(output.contains("101") && output.contains("Alice") && output.contains("20"));
    }

    @Test
    void testSearchStudentById() {
        // TC4: Search for a student by ID
        Scanner scanner = new Scanner("101\nAlice\n20\n");
        system.addNewStudent(scanner); // Add a student
        outputStream.reset(); // Clear the output

        Scanner searchScanner = new Scanner("101\n");
        system.searchStudentById(searchScanner);
        assertTrue(outputStream.toString().contains("ID: 101, Name: Alice, Age: 20"));
    }

    @Test
    void testSearchNonExistingStudent() {
        // TC5: Search for a non-existing ID
        Scanner scanner = new Scanner("999\n");
        system.searchStudentById(scanner);
        assertTrue(outputStream.toString().contains("Student not found."));
    }

    @Test
    void testRemoveStudentById() {
        // TC6: Remove a student by ID
        Scanner scanner = new Scanner("101\nAlice\n20\n");
        system.addNewStudent(scanner); // Add a student
        outputStream.reset(); // Clear the output

        Scanner removeScanner = new Scanner("101\n");
        system.removeStudentById(removeScanner);
        assertTrue(outputStream.toString().contains("Student with ID 101 removed successfully!"));
    }

    @Test
    void testRemoveNonExistingStudent() {
        // TC7: Remove a non-existing student
        Scanner scanner = new Scanner("999\n");
        system.removeStudentById(scanner);
        assertTrue(outputStream.toString().contains("Error: Student with ID 999 not found."));
    }

    @Test
    void testDisplayAllStudentsEmpty() {
        // TC8: Display all students (empty)
        system.displayAllStudents();
        assertTrue(outputStream.toString().contains("No students found."));
    }
}