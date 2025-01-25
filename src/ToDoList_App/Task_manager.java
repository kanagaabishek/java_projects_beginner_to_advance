package ToDoList_App;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Task_manager {
    //Usage of ArrayList For storing the tasks details
    ArrayList<Tasks> tasks = new ArrayList<>();

    //Method for Addition of tasks
    public void addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Name: ");
        String taskName = sc.nextLine();
        System.out.println("Enter Task Priority (1.High,2.Medium,3.Low): ");
        int taskPriority = sc.nextInt();
        sc.nextLine();
        Tasks task = new Tasks(taskName,false,taskPriority);
        tasks.add(task);
        System.out.println("Task Added successfully");
    }

    //method for editing the tasks
    public void editTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Name to edit: ");
        String taskName = sc.nextLine();
        for (Tasks task : tasks) {
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                System.out.println("1.Edit Task Name");
                System.out.println("2.Edit Task Priority");
                System.out.println("3.Mark as Done");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:System.out.println("Enter new Task Name");
                    task.setTaskName(sc.nextLine());
                    System.out.println("Task Edited Successfully");
                    break;
                    case 2:System.out.println("Enter new Task Priority");
                    task.setTaskPriority(sc.nextInt());
                    System.out.println("Task Edited Successfully");
                    break;
                    case 3:
                        task.setIsDone(true);
                        System.out.println("Task marked as Done! ");
                        break;
                        default:System.out.println("Invalid Choice");
                }
                return;
            }
            else{
                System.out.println("Invalid Task Name");
            }
        }

    }

    //metHod for displaying the tasks
    public void DisplayTasks() {
        int i = 1;
        if(tasks.isEmpty()){
            System.out.println("No Tasks Found");
            return;
        }
        for (Tasks task : tasks) {
            System.out.println(i + "." + task);
            i++;
        }
    }

    //deleting the task
    public void removeTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Name to remove: ");
        String taskName = sc.nextLine();
        for (Tasks task : tasks) {
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                tasks.remove(task);
                return;
            }
            System.out.println("Task does not exist");
        }
        System.out.println("Task Removed successfully");
    }

    //Sorting the taskslist using priority
    public void sortPrioritisation() {
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }
        else{
            tasks.sort(Comparator.comparingInt(Tasks::getTaskPriority));
            System.out.println("Tasks sorted by priority");
        }

    }

    public void SaveTasks() {
        try (FileWriter fw = new FileWriter("tasks.txt")) {
            for (Tasks task : tasks) {
                fw.write(task.getTaskName() + "," + task.getIsDone() + "," + task.getTaskPriority());
            }
            System.out.println("Saved Tasks.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void LoadTasks() {
        tasks.clear();
        try(BufferedReader br = new BufferedReader(new FileReader("Tasks.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length == 3){
                    String taskName = data[0];
                    boolean isDone = data[1].equals("1");
                    int taskPriority = Integer.parseInt(data[2]);
                    Tasks task = new Tasks(taskName,isDone,taskPriority);
                    tasks.add(task);
                }
            }
            System.out.println("Loaded Tasks.txt");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
