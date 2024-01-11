package com.example.lamafirstproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SignUpActivity extends AppCompatActivity {
    EditText etUser, etpwd, etRpwd, etFullName, etPhone;
            Button btnrgstr, btnlog;
                    DBHelper Dbhelper;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUser = findViewById(R.id.etUsername);
        etpwd = findViewById(R.id.etPassword);
        etRpwd = findViewById(R.id.etrePassword);
        etFullName = findViewById(R.id.etFullName);  // Add this line
        etPhone = findViewById(R.id.etPhone);
        btnrgstr = findViewById(R.id.btnRegister);
        Dbhelper = new DBHelper(this);
        btnlog = findViewById(R.id.btnLogin);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigation(item.getItemId());
                return true;
            }
        });
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnrgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pwd , rePwd, fullName, phone;
                user = etUser.getText().toString();
                pwd = etpwd.getText().toString();
                rePwd = etRpwd.getText().toString();
                fullName = etFullName.getText().toString();  // Add this line
                phone = etPhone.getText().toString();
                if (user.equals("") || pwd.equals("")|| rePwd.equals("") || fullName.equals("") || phone.equals("")) {
                    Toast.makeText(SignUpActivity.this," Please fill all the fields", Toast.LENGTH_LONG).show();
                }else{
                    if (pwd.equals(rePwd)){
                        if(Dbhelper.checkusername(user)){
                            Toast.makeText(SignUpActivity.this, "User Already exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        boolean registerSuccess = Dbhelper.insertData(user, pwd, fullName, phone);
                       if (registerSuccess)
                           Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                       else{
                           Toast.makeText(SignUpActivity.this, "User Registered Failed", Toast.LENGTH_SHORT).show();
                       }
                    }
                    else{
                        Toast.makeText(SignUpActivity.this," Passwords do not match", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        btnlog = findViewById(R.id.btnLogin);


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