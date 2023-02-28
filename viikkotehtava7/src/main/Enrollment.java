package main;
public class Enrollment {
    private int grade;
    private Student student;
    private Course course;

    public Enrollment(){}

    public Enrollment(Student student, Course course){
        this.student = student;
        this.course = course;
        grade = -1;
    }

    public void gradeCourse(int grade){
        this.grade = grade;
    }

    public Student getStudent(){
        return student;
    }

    public Course getCourse(){
        return course;
    }

    public int getGrade(){
        return grade;
    }
}
