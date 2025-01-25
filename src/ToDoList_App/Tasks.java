package ToDoList_App;

public class Tasks {
    private String taskName;
    private boolean isDone;
    private int taskPriority;

    //Assigning of getters and setters
    public Tasks(String taskName, Boolean isDone, int taskPriority) {
        this.taskName = taskName;
        this.isDone = isDone;
        this.taskPriority = taskPriority;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    public int getTaskPriority() {
        return taskPriority;
    }
    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        String status = isDone ? "Done" : "Not Done";
        String priority = switch (taskPriority){
            case 1 -> "High";
            case 2 -> "Medium";
            case 3 -> "Low";
            default -> "Unknown";

        };
        return taskName +" " +priority+" - " + status;
    }
}
