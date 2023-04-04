package com.example.rekisteri;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Not in use
     * @param id of user
     */
    public void removeUser(int id){
        users.remove(id);
    }

    public void saveUsers(Context context) {
        try{
            ObjectOutputStream saver = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            saver.writeObject(users);
            saver.close();
            System.out.println("Käyttäjien tallennus onnistui");
        }catch(IOException e){
            System.out.println("Käyttäjien tallenus epäonnistui");
        }
    }

    public void loadUsers(Context context) {
        try{
            ObjectInputStream loader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) loader.readObject();
            loader.close();
            System.out.println("Käyttäjät ladattu");
        }catch(Exception e){
            System.out.println("Tiedostoa ei voinut lukea");
            e.printStackTrace();
        }
    }
}
