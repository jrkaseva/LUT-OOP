package main;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Author: Joakim Kaseva
 * LUT OOP course
 * Last modified 7.2.2023
 */
public class Calculator {
    /**
     * @param s student
     * @return average
     */
    public static double getAverageGrade(Student s){
        ArrayList<Double> grades = gradesToList(s);
        if (grades.isEmpty()) return 0;
        double average = 0;
        for (double i : grades){
            average += i;
        }
        average /= grades.size();
        return average;
    }

    /**
     * @param s student
     * @return median
     */
    public static double getMedianGrade(Student s){
        ArrayList<Double> grades = gradesToList(s);
        if (grades.isEmpty()) return 0;
        if (grades.size() % 2 == 0){
            int idx = grades.size() / 2;
            double med = (grades.get(idx - 1) + grades.get(idx)) / 2;
            return med;
        }
        else {
            return grades.get(grades.size()/2);
        }
    }

    /**
     * @param s student
     * @return sorted array of grades only
     */
    public static ArrayList<Double> gradesToList(Student s){
        ArrayList<Double> arr = new ArrayList<Double>();
        for (double i : s.getGrades().values()){
            arr.add(i);
        }
        Collections.sort(arr);
        return arr;
    }

    /**
     * default constructor
     */
    public Calculator(){}
}
