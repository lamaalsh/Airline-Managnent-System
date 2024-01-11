package com.example.lamafirstproject;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    private DBHelper dbh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_prof);

        dbh = new DBHelper(this);

        // Get the username from the intent
        String username = getIntent().getStringExtra("username");

        // Assuming you have a DBHelper object named 'dbh'
        // Retrieve user data from the database based on the username
        Cursor cursor = dbh.getUserData(username);

        if (cursor.moveToFirst()) {
            // Retrieve user information from the cursor
            @SuppressLint("Range") String fullName = cursor.getString(cursor.getColumnIndex("full_name"));
            @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));

            // Update UI with user information
            TextView textViewWelcome = findViewById(R.id.textViewWelcome);
            TextView textViewUsername = findViewById(R.id.textViewUsername);
            TextView textViewFullName = findViewById(R.id.textViewFullName);
            TextView textViewPhone = findViewById(R.id.textViewPhone);

            textViewWelcome.setText("Welcome to Your Profile!");
            textViewUsername.setText("Username: " + username);
            textViewFullName.setText("Full Name: " + fullName);
            textViewPhone.setText("Phone: " + phone);
        }

        cursor.close();

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}