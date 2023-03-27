package com.example.rekisteri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class ShowUsersActivity extends AppCompatActivity {
    private UserStorage storage;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        storage = UserStorage.getInstance();
        rv = findViewById(R.id.rvUsers);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ShowUserAdapter(getApplicationContext(), storage.getUsers()));
    }
}