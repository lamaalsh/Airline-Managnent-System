package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    Button bot, bot1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        bot=findViewById(R.id.insertDataButton);






        bot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Intent intent = new Intent (Admin.this, insertdata.class);
                    startActivity(intent);



            }
        });

    }
}
