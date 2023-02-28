package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

    public Gifu(){}

    public Gifu(String name){
        university = name;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public Course getCourse(int id){
        for(Course c : courses){
            if (c.getId() == id){
                return c;
            }
        }
        System.out.println("Ei löytynyt kurssia id:llä +" + id);
        return null;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void listCourses(){
        int count = 0;
        for(Course c : courses){
            System.out.println(count + ") " + c.getInformation());
            count++;
        }
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(int id){
        for(Student s : students){
            if (s.getId() == id){
                return s;
            }
        }
        System.out.println("Ei löytynyt opiskelijaa id:llä " + id);
        return null;
    }

    public void enrollStudent(Student student, Course course){
        enrollments.add(new Enrollment(student, course));
    }

    public void listStudents(){
        int count = 0;
        for(Student s : students){
            System.out.println(count + ") " + s.getInformation());
            count++;
        }
    }

    public ArrayList<Enrollment> getEnrollments(){
        return enrollments;
    }
}
