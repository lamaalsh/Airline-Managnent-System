package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class page2act extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
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

        }}


    public void goToExampleActivity(View view) {
        Intent intent = new Intent(this, UserList.class);
        startActivity(intent);
    }


}
