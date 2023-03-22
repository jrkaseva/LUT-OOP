package com.example.rekisteri;

import java.util.ArrayList;

public class UserStorage {
    private static UserStorage storage = null;
    private ArrayList<User> users = new ArrayList<User>();

    public static UserStorage getInstance(){
        if(storage == null){
            storage = new UserStorage();
        }
        return storage;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    /**
     * Not in use
     * @param id of user
     */
    public void removeUser(int id){
        users.remove(id);
    }
}
