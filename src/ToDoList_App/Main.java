package ToDoList_App;

/*
* BluePrint
* To-Do-List Application (3rd Project)
* three classes
* -Main
* -Tasks
* -Task_manager
* -Main
*   -Menu driven interface
*   -Using do-while loop
*   -Enabling user to use different methods
* Tasks
*   -Setters and getters
* Task_manager
*   -Method such as
*      - Add task
*      - edit task
*      - display task(Both pending and completed tasks)
*      - mark as complete task
*   - Usage a file to save and load tasks
*   - Usage of Arraylist for storing tasks
*  Designed and Developed by Kanaga Abishek.B (me)
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Menu driven Interface for users
        System.out.println("To-Do List Application");
        Task_manager task_manager = new Task_manager();
        int choice;
        Scanner sc = new Scanner(System.in);
        //ShowCasing the Methods for the users using do-while loop
        do {
            System.out.println("\t MENU ");
            System.out.println("1.Add tasks");
            System.out.println("2.Show all tasks");
            System.out.println("3.Sort task by priority");
            System.out.println("4.Edit task");
            System.out.println("5.Delete task");
            System.out.println("6.Save tasks");
            System.out.println("7.Load tasks");
            System.out.println("8.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:task_manager.addTask();
                break;
                case 2:task_manager.DisplayTasks();
                break;
                case 3:task_manager.sortPrioritisation();
                break;
                case 4:task_manager.editTask();
                break;
                case 5:task_manager.removeTask();
                break;
                case 6:task_manager.SaveTasks();
                break;
                case 7:task_manager.LoadTasks();
                break;
                case 8:System.out.println("Exiting........");
                break;
                default:System.out.println("Wrong option");
            }
        }while (choice != 8);
    }
}
