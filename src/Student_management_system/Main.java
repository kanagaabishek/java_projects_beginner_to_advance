package Student_management_system;

/*
* Blueprint for this Application
* Student management system (2nd Project)
* Three Classes
* -Main
* -student
* -student management
* Class student for setters and getters
* -Name,Id,marks(getter and setters)
* Class student_management
* -Methods
*   - add student
*   - Display students
*   - update student details (both name and id)
*   - remove student
*   - Sorting students based on marks
* -Usage of HashMap and ArrayList for Storing Information
* Main Class
* -Provide a menu-driven interface
*   - Which allows users to use above methods
*   - Usage of do-while loop to repeat the menu until the user Exits
* - Exiting with the Thankyou Statement
*
* Here is the Complete Student management system application
* Design and developed by Kanaga Abishek.B
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Student Management System");

        student_management system = new student_management(); // Create only one instance

        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.removeStudent();
                    break;
                case 3:
                    system.updateStudent();
                    break;
                case 4:
                    system.display();
                    break;
                case 5:
                    system.sortStudentsByMarks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        System.out.println("\nThank you for using this program.");

        sc.close();
    }
}
