package com.example.lamafirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, admin;
    DBHelper dbh;
    EditText etUsername, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbh = new DBHelper(this);
        etUsername = findViewById(R.id.etUsername);
        etPwd = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        admin = findViewById(R.id.admin);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoadmin();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoggedIn = dbh.checkUser(etUsername.getText().toString(), etPwd.getText().toString());
                if (isLoggedIn) {
                    // Handle successful login, e.g., navigate to ProfileFragment
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", etUsername.getText().toString());
                    profileFragment.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, profileFragment)
                            .commit();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void gotoadmin() {
        Intent intent = new Intent(LoginActivity.this, AdminLogin.class);
        startActivity(intent);
    }
}
