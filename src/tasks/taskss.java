package tasks;/*
* Task class is created
* set task function is created
* likewise get task is created and to display them*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taskss {
    private String task;
    private List<String> taskslist = new ArrayList<String>();


    public void setTask(String task) {
        this.task = task;
        taskslist.add(task);
    }
    public String getTask() {
        return task;
    }
    public void display() {
        for(String task : taskslist) {
            System.out.println(task);
        }
    }
    public void removeTask() {
        System.out.println("Enter the task to remove");
        Scanner sc = new Scanner(System.in);
        task = sc.nextLine();
        taskslist.remove(task);
    }

    public void getuserinput(){
        System.out.println("Enter the task :");
        Scanner sc = new Scanner(System.in);
        String task = sc.nextLine();
        setTask(task);
    }
}
