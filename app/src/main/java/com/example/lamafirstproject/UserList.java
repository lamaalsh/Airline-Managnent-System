package com.example.lamafirstproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> Expo, Cour;
    MyAdapter adapter;
    DBHelper DB;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list );
        DB= new DBHelper(this);
        Cour = new ArrayList<>();
        Expo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, Cour, Expo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigation(item.getItemId());
                return true;
            }
        });
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount()==0){
            Toast.makeText(UserList.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while(cursor.moveToNext()){
                Cour.add(cursor.getString(1));
                Expo.add(cursor.getString(0));


            }
        }
    }
    private void handleNavigation(int itemId) {
        Intent intent;
        if (itemId == R.id.navigation_home) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.navigation_dashboard) {
            intent = new Intent(this, page2act.class);
            startActivity(intent);
        } else if (itemId == R.id.navigation_profile) {
            intent = new Intent(this, LearnMore.class);
            startActivity(intent);

        }
    }


}
