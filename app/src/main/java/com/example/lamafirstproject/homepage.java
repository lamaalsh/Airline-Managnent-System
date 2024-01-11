package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {

    private SeekBar seekBarExperience;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

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

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the experience dialog
                showExperienceDialog();
            }
        });
        Button learn = findViewById(R.id.button2);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, LearnMore.class);
                startActivity(intent);
            }
        });


        Button sign = findViewById(R.id.button);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        Button ourCoursesButton = findViewById(R.id.button1); // Replace with the actual button ID
        ourCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, page2act.class);
                startActivity(intent);
            }
        });
    }

    // Other overridden methods...

    // Inside your activity or fragment
    private void showExperienceDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_experience, null);
        dialogBuilder.setView(dialogView);

        seekBarExperience = dialogView.findViewById(R.id.seekBarExperience);
        final TextView textViewExperience = dialogView.findViewById(R.id.textViewExperience);
        Button submitButton = dialogView.findViewById(R.id.submitButton);

        int initialExperience = 5;
        textViewExperience.setText(getString(R.string.experience_rating, initialExperience));

        seekBarExperience.setProgress(initialExperience);
        seekBarExperience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewExperience.setText(getString(R.string.experience_rating, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userRating = seekBarExperience.getProgress();
                alertDialog.dismiss();

                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void handleNavigation(int itemId) {
        Intent intent;
        if (itemId == R.id.navigation_home) {
            intent = new Intent(this, homepage.class);
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