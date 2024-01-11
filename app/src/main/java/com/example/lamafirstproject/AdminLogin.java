package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {
    Button btn;
    EditText usrn,pass;
    DBHelper dbh;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        dbh = new DBHelper(this);
        btn = findViewById(R.id.abtn);
        usrn = findViewById(R.id.AUsername);
        pass = findViewById(R.id.APassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoggedIn = dbh.checkAdminCredentials(usrn.getText().toString(), pass.getText().toString());
                if (isLoggedIn){
                    Intent intent = new Intent (AdminLogin.this, Admin.class);
                    startActivity(intent);
                }
                else Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_LONG).show();



            }
        });
    }



    }



