package main;
import java.io.Serializable;
import java.util.LinkedHashMap;
/**
 * Author: Joakim Kaseva
 * LUT OOP course
 * Last modified 7.2.2023
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 143251451L;
    /**
     * Grades in fromat of (Course, Grade).
     */
    private LinkedHashMap<String, Double> grades = new LinkedHashMap<String, Double>();
    /**
     * Student's name
     */
    private String name = "Joakim";
    /**
     *  Unique student number for students
     */
    private int student_number = 0;

    /**
     * Default constructor
     */
    public Student() {}

    /**
     * @param name of student
     * @param number of student number
     */
    public Student(String name, int number) {
        this.name = name;
        student_number = number;
    }

    /**
     * @param course to add
     * @param grade of course
     */
    public void addGrade(String course, double grade) {
        grades.put(course, grade);
    }

    /**
     * @return get()-method for grades
     */
    public LinkedHashMap<String, Double> getGrades(){
        return grades;
    }

    /**
     * lists courses and their grades
     */
    public void listGrades(){
        for (String course : grades.keySet()){
            System.out.println(String.format("%s: %.0f", course, grades.get(course)));
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return String.format("%d: %s", student_number, name);
    }

    /**
     * @return get()-method for name
     */
    public String getName(){
        return name;
    }
}
