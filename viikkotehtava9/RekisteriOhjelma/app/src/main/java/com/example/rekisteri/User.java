package com.example.rekisteri;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private int image;

    public User(){}

    public User(String firstName, String lastName, String email, String degreeProgram, int imgPosition){
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

    @Override
    public String toString(){
        return String.format("%s %s, %s, %s", firstName, lastName, degreeProgram, email);
    }

    public int getImage() {
        return image;
    }
}
