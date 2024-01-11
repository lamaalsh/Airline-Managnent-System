package com.example.lamafirstproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("MasterX");
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigation(item.getItemId());
                return true;
            }
        });

        Button sign = findViewById(R.id.button);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        Button learn = findViewById(R.id.button2);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnMore.class);
                startActivity(intent);
            }
        });

        Button ourCoursesButton = findViewById(R.id.button1); // Replace with the actual button ID
        ourCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, page2act.class); // Replace with the actual activity class for Page2
                startActivity(intent);
            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Inflate the custom menu item layout
        MenuItem item = menu.findItem(R.id.action_login);
        item.setActionView(R.layout.custom_menu_item);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_login) {
            Intent intent = new Intent(MainActivity.this,TeamActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }



    public boolean onContextItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.context_item1)
        {
            // Handle context_item1 selection
            Toast.makeText(this, "Context 1 ", Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.context_item2)
        {
            Toast.makeText(this, "context 2 ", Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onContextItemSelected(item);
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


}