package com.example.rekisteri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private UserStorage storage;
    EditText firstName;
    EditText lastName;
    EditText email;
    RadioButton buttonIT;
    RadioButton buttonTT;
    RadioButton buttonLT;
    RadioButton buttonST;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.editTextFirstname);
        lastName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmail);
        buttonIT = findViewById(R.id.buttonIT);
        buttonTT = findViewById(R.id.buttonTt);
        buttonLT = findViewById(R.id.buttonLt);
        buttonST = findViewById(R.id.buttonSt);
        spinner = findViewById(R.id.ddImage);

        storage = UserStorage.getInstance();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.images, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    public void addUser(View view){
        String degreeProgram;
        RadioGroup rg = findViewById(R.id.radioGroup);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.buttonIT: degreeProgram = "Tietotekniikka"; break;
            case R.id.buttonTt: degreeProgram = "Tuotantotalous"; break;
            case R.id.buttonLt: degreeProgram = "Laskennallinen tekniikka"; break;
            case R.id.buttonSt: degreeProgram = "Sähkötekniikka"; break;
            default: System.out.println("Ei valittua opintoa"); return;
        }

        String currEmail = email.getText().toString();
        if (currEmail.isEmpty()){
            System.out.println("Virheellinen sähköpostiosoite");
            return;
        }

        storage.addUser(new User(firstName.getText().toString(),
                lastName.getText().toString(), currEmail, degreeProgram, spinner.getSelectedItemPosition()));

        System.out.println("Lisätty käyttäjä sähköpostilla: " + currEmail);
        firstName.setText("Etunimi");
        lastName.setText("Sukunimi");
        email.setText("");
        rg.check(R.id.buttonIT);
    }

    public void printUsers(){
        for (User u: storage.getUsers()){
            System.out.println(u);
        }
    }

    public void switchToShowUsers(View view){
        printUsers();
        Intent intent = new Intent(this, ShowUsersActivity.class);
        startActivity(intent);
    }

    /**
     * Not implemented yet
     */
    public void removeUser(View view){
        System.out.println("Ominaisuus ei ole käytössä");
    }
}