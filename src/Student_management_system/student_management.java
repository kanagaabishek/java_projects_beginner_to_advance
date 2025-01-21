package Student_management_system;

import java.util.*;

public class student_management {
    private final HashMap<Integer, student> students = new HashMap<>();

    // Method to add a student
    public void addStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student marks: ");
        int marks = sc.nextInt();

        students.put(id, new student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // Method to display all students
    public void display() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("ID\tName\tMarks");
        for (student s : students.values()) {
            System.out.println(s.getId() + "\t " + s.getName() + "\t  " + s.getmarks());
        }
    }

    // Method to remove a student
    public void removeStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student ID to remove: ");
        int id = sc.nextInt();

        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to update student details
    public void updateStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (students.containsKey(id)) {
            student s = students.get(id);

            System.out.print("Update name? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
            }

            System.out.print("Update marks? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter new marks: ");
                s.setmarks(sc.nextInt());
            }

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to sort students by marks
    public void sortStudentsByMarks() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        List<student> studentList = new ArrayList<>(students.values());
        studentList.sort(Comparator.comparingInt(student::getmarks).reversed());

        System.out.println("Students sorted by marks (highest to lowest):");
        System.out.println("ID\tName\tMarks");
        for (student s : studentList) {
            System.out.println(s.getId() + "\t " + s.getName() + "\t  " + s.getmarks());
        }
    }
}
