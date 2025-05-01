import java.util.Scanner;

public class GradebookMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook manager = new Gradebook();  

        while (true) {
            System.out.println("\n--- Welcome to the Gradebook Menu! ---");
            System.out.println("1. Add Student"); 
            System.out.println("2. View Rankings");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    manager.addStudent(scanner);
                    break;
                case 2:
                    manager.viewRankings();
                    break;
                case 3:
                    manager.searchStudentById(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();  
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            // Prompts user if they want to return to the menu
            System.out.println("\nWould you like to return to the menu? (yes/no)");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close(); 
    }
}
