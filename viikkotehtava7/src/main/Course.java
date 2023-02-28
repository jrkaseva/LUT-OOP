package main;

public class Course implements PrintInfo{
    private int maxNumberOfStudents;
    private String name;
    private String id;

    public Course() {}

    public Course(String name, String id, int maxNumberOfStudents){
        this.name = name;
        this.id = id;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public String getInformation(){
        return id + " " + name;
    }

    public int getId(){
        return Integer.parseInt(id);
    }
}
