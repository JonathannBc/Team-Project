import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Gradebook {

    // Lists to store undergraduate and graduate students 
    private List<Undergrad> undergrads = new ArrayList<>();
    private List<Graduate> grads = new ArrayList<>();

    //course lists for each student type
    private static final String[] UNDERGRADUATE_COURSES = {"CS201", "CS251", "CS371"};
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
        String[] selectedCourses;
        if (type == 1) {
            selectedCourses = UNDERGRADUATE_COURSES;
        } else if (type == 2) {
            selectedCourses = GRADUATE_COURSES;
        } else {
            System.out.println("Invalid type selected. Student not added.");
            return;
        }
        // Loop through selected courses and input grades
        for (String course : selectedCourses) {
            System.out.print("Enter grade for course " + course + ": ");
            double grade = input.nextDouble();
            input.nextLine();
            // Add course with grade to list
            courseList.add(new Courses(course, grade)); 
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
    public void removeStudent(Scanner input) {
        System.out.print("Enter student ID to remove: ");
        int removeId = input.nextInt();
        input.nextLine(); // Clear newline character
    
        boolean found = false;
    
        // Try to remove from undergraduates
        for (int i = 0; i < undergrads.size(); i++) {
            if (undergrads.get(i).getId() == removeId) {
                // Remove the student
                undergrads.remove(i);  
                System.out.println("Undergraduate student with ID " + removeId + " has been removed.");
                found = true;
                break;
            }
        }
    
        // If not found in undergraduates, try graduates
        if (!found) {
            for (int i = 0; i < grads.size(); i++) {
                if (grads.get(i).getId() == removeId) {
                    grads.remove(i);  // Remove the student
                    System.out.println("Graduate student with ID " + removeId + " has been removed.");
                    found = true;
                    break;
                }
            }
        }
    
        // If student was not found
        if (!found) {
            System.out.println("Student with ID " + removeId + " not found.");
        }
    }
    

    public void viewRankings() {
    // Sort undergrads by name alphabetically
    System.out.println("\n--- Undergraduate Rankings (Alphabetical) ---");
    // Sort alphabetically by name
    Collections.sort(undergrads);  
    for (int i = 0; i < undergrads.size(); i++) {
        System.out.println("#" + (i + 1));
        undergrads.get(i).display();  
    }

    // Sort grads by name alphabetically
    System.out.println("\n--- Graduate Rankings (Alphabetical) ---");
    Collections.sort(grads);
    for (int i = 0; i < grads.size(); i++) {
        System.out.println("#" + (i + 1));
        grads.get(i).display();
    }
}

    // Method to search for a student by their ID
    public void searchStudentById(Scanner input) {
        System.out.print("Enter student ID to search: ");
        int searchId = input.nextInt();
        input.nextLine(); 

        boolean found = false;

        // Search undergraduates first
        for (Undergrad u : undergrads) {
            if (u.getId() == searchId) {
                System.out.println("\nStudent found:");
                u.display(); 
                found = true;
                break;
            }
        }

        // If not found in undergrads, search graduates
        if (!found) {
            for (Graduate g : grads) {
                if (g.getId() == searchId) {
                    System.out.println("\nStudent found:");
                    g.display(); 
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