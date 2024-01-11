package com.example.lamafirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class insertdata extends AppCompatActivity {
    EditText Course_Name, Exp;
    Button insert, view;
    DBHelper DB;Button delete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.insert_courses);
        Course_Name= findViewById(R.id.course_name);
        Exp= findViewById(R.id.Explanation);
        insert = findViewById(R.id.insertdata);
        view = findViewById(R.id.viewdata);

        DB= new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(insertdata.this, UserList.class));
            }
        });
        delete = findViewById(R.id.deleteData);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CourseName = Course_Name.getText().toString();
                String Explanation = Exp.getText().toString();

                Boolean checkinsertdata = DB.insertcoursedata(CourseName, Explanation);
                if (checkinsertdata == true)
                {
                    showSuccessDialog();
                    Toast.makeText(insertdata.this, "New Entry Inserted", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(insertdata.this,"New Entry Not inserted", Toast.LENGTH_LONG).show();
                    showfailDialog();
                }

            }
        });
    }

    private void deleteData() {
        String courseNameToDelete = Course_Name.getText().toString();

        // Call the delete method from your DBHelper class
        boolean isDeleted = DB.deleteCourseData(courseNameToDelete);

        // Check if the data was successfully deleted and show a toast message
        if (isDeleted) {
            Toast.makeText(insertdata.this, "Entry Deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(insertdata.this, "Entry Not Deleted", Toast.LENGTH_LONG).show();
        }
    }
    private void showSuccessDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_insert_success, null);


        final androidx.appcompat.app.AlertDialog dialog = new androidx.appcompat.app.AlertDialog.Builder(this)
                .setView(dialogView)
                .create();


        Button btnDismiss = dialogView.findViewById(R.id.btnDismiss);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }
    private void showfailDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_insert_failed, null);


        final androidx.appcompat.app.AlertDialog dialog = new androidx.appcompat.app.AlertDialog.Builder(this)
                .setView(dialogView)
                .create();
        Button btn = dialogView.findViewById(R.id.btnDismiss1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }
}
