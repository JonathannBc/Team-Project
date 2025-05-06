import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Gradebook {

    // Lists to store undergraduate and graduate students 
    private List<Undergrad> undergrads = new ArrayList<>();
    private List<Graduate> grads = new ArrayList<>();

    //course lists for each student type
    private static final String[] UNDERGRADUATE_COURSES = {"CS201", "CS202", "CS203", "CS204", "CS205"};
    private static final String[] GRADUATE_COURSES = {"CS450", "CS451", "CS452"};

    // Method to add a student to the gradebook
    public void addStudent(Scanner input) {
        // Prompt for student name
        System.out.print("Name: ");
        String name = input.nextLine();

        // Prompt for student ID
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine(); 

        // Prompt to select student type: 1 for Undergrad, 2 for Graduate
        System.out.println("Type: 1. Undergraduate  2. Graduate");
        int type = input.nextInt();
        input.nextLine(); 

        // List to hold the course objects for the student
        List<Courses> courseList = new ArrayList<>();

        // Choose course set based on student type
        String[] selectedCourses = (type == 1) ? UNDERGRADUATE_COURSES : GRADUATE_COURSES;

        // Loop through selected courses and input grades
        for (String course : selectedCourses) {
            System.out.print("Enter grade for course " + course + ": ");
            double grade = input.nextDouble();
            input.nextLine();
            // Add course with grade to list
            courseList.add(new Courses(course, grade)); 
        }

        // Each course is worth 4 credits
        int totalCredits = courseList.size() * 4;

        // Ensure the student meets the minimum credit requirement (15 credits)
        if (totalCredits < 15) {
            System.out.println("Student must have at least 15 credits. Not added.");
            return;
        }

        // Add the student to the appropriate list based on type
        if (type == 1) {
            undergrads.add(new Undergrad(name, id, courseList));
        } else if (type == 2) {
            grads.add(new Graduate(name, id, courseList));
        } else {
            System.out.println("Invalid type.");
        }
    }

    // Method to view student rankings
    public void viewRankings() {
        // Sort undergrads by GPA in descending order and display them
        System.out.println("\n--- Undergraduate Rankings ---");
        undergrads.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        for (int i = 0; i < undergrads.size(); i++) {
            System.out.println("#" + (i + 1)); // Display ranking number
            undergrads.get(i).display(); // Display student details
        }

        // Sort grads by GPA in descending order and display them
        System.out.println("\n--- Graduate Rankings ---");
        grads.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        for (int i = 0; i < grads.size(); i++) {
            System.out.println("#" + (i + 1)); // Display ranking number
            grads.get(i).display(); // Display student details
        }
    }

    // Method to search for a student by their ID
    public void searchStudentById(Scanner input) {
        System.out.print("Enter student ID to search: ");
        int searchId = input.nextInt();
        input.nextLine(); // Clear newline character

        boolean found = false;

        // Search undergraduates first
        for (Undergrad u : undergrads) {
            if (u.getId() == searchId) {
                System.out.println("\nStudent found:");
                u.display(); // Display matching student
                found = true;
                break;
            }
        }

        // If not found in undergrads, search graduates
        if (!found) {
            for (Graduate g : grads) {
                if (g.getId() == searchId) {
                    System.out.println("\nStudent found:");
                    g.display(); // Display matching student
                    found = true;
                    break;
                }
            }
        }

        // If student was not found at all
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }
}
