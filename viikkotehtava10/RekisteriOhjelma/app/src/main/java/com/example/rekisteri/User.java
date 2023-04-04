package com.example.rekisteri;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Comparable<User>, Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private ArrayList<String> degrees;
    private int image;

    public User(){}

    public User(String firstName, String lastName, String email, String degreeProgram, int imgPosition, ArrayList<String> degrees){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        switch (imgPosition){
            case 1:
                image = R.drawable.user_photo_v2;
                break;
            case 2:
                image = R.drawable.user_photo_v3;
                break;
            default:
                image = R.drawable.user_photo;
        }
        this.degrees = degrees;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }

    public ArrayList<String> getDegrees() {
        return degrees;
    }

    @Override
    public String toString(){
        return String.format("%s %s, %s, %s", firstName, lastName, degreeProgram, email);
    }

    public int getImage() {
        return image;
    }

    @Override
    public int compareTo(User o) {
        return this.getLastName().charAt(0) - o.getLastName().charAt(0);
    }
}
