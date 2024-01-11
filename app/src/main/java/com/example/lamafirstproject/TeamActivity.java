package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

// Inside your Activity or Fragment
public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigation(item.getItemId());
                return true;
            }
        });

        List<TeamMember> teamMembers = new ArrayList<>();
        teamMembers.add(new TeamMember("Manager", R.drawable.manager_image));
        teamMembers.add(new TeamMember("Founder", R.drawable.founder_image));
        teamMembers.add(new TeamMember("Employee 1", R.drawable.employee1_image));
        teamMembers.add(new TeamMember("Employee 2", R.drawable.employee2_image));

        TeamMembersAdapter adapter = new TeamMembersAdapter(teamMembers);
        recyclerView.setAdapter(adapter);
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
