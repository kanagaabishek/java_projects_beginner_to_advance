package tasks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
* Personnel manager project
* two classes-
* tasks-add,delete
* event-add,delete
* expense-salary,expense,savings
*  */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        taskss task = new taskss();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add Task");
            System.out.println("2.Remove Task");
            System.out.println("3.Show Task");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:task.getuserinput();
                break;
                case 2:task.removeTask();
                break;
                case 3:task.display();
                break;
                case 4:System.out.println("Exiting program");
                break;
            }
        }while (choice != 4);
        System.out.println("Thank you for using our program");

    }
}