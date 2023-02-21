package main;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Author: Joakim Kaseva
 * LUT OOP course
 * Last modified 7.2.2023
 */
public class University {
    /**
     *  Array of students
     */
    private ArrayList<Student> students = new ArrayList<Student>();

    /**
     * Default constructor
     */
    public University() {}

    /**
     * @param student to add
     */
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * @param tiedot if listing also student number
     */
    public void listStudents(boolean student_number){
        if (student_number){
            for (Student s : students) {
                System.out.println(s);
            }
        }
        else {
            for (int i = 0; i < students.size(); i++){
                System.out.println(String.format("%d: %s", i, students.get(i).getName()));
            }
        }
    }

    /**
     * @param index of student given by user
     * @return Student or null if out of bounds
     */
    public Student getStudent(int index){
        if (contains(index)) return students.get(index);
        System.out.println("Syöte oli väärä");
        return null;
    }

    /**
     * @param index given by user
     * @return true if is within size of arraylist
     */
    public boolean contains(int index){
        return index < students.size();
    }

    /**
     * @param file to save to
     */
    public void saveToFile(String file){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(students);
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe tallennettaessa");
            e.printStackTrace();
        }
    }

    /**
     * @param file to load from
     */
    public void loadFromFile(String file){
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            students = (ArrayList<Student>) reader.readObject();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Virhe tallennettaessa");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
