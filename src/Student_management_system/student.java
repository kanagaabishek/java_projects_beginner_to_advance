package Student_management_system;

public class student {
    private int id;
    private String name;
    private int marks;

    // Constructor
    public student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getmarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setmarks(int marks) {
        this.marks = marks;
    }
}
