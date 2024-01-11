package com.example.lamafirstproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class confirm extends AppCompatActivity {

    private RadioGroup radioGroupLevel;
    private CheckBox checkboxConfirmation;
    private CheckBox checkboxVideo;
    private CheckBox checkboxText;
    private CheckBox checkboxAudio;
    private Spinner spinnerDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        // Initialize views
        radioGroupLevel = findViewById(R.id.radioGroupLevel);
        checkboxConfirmation = findViewById(R.id.checkboxConfirmation);
        checkboxVideo = findViewById(R.id.checkboxVideo);
        checkboxText = findViewById(R.id.checkboxText);
        checkboxAudio = findViewById(R.id.checkboxAudio);
        spinnerDuration = findViewById(R.id.spinnerDuration);

        // Create a list of options for the spinner
        List<String> durations = new ArrayList<>();
        durations.add("1 week");
        durations.add("2 weeks");
        durations.add("1 month");
        durations.add("3 months");

        // Create an ArrayAdapter using the string list and default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, durations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDuration.setAdapter(adapter);

        spinnerDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDuration = parent.getItemAtPosition(position).toString();
                // Perform actions based on the selected item
                Toast.makeText(confirm.this, "Selected: " + selectedDuration, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve selected level
                int selectedRadioButtonId = radioGroupLevel.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedLevel = selectedRadioButton.getText().toString();

                // Retrieve confirmation status
                boolean isConfirmed = checkboxConfirmation.isChecked();

                // Retrieve selected material types
                String selectedMaterials = "";
                if (checkboxVideo.isChecked()) {
                    selectedMaterials += "Video ";
                }
                if (checkboxText.isChecked()) {
                    selectedMaterials += "Text ";
                }
                if (checkboxAudio.isChecked()) {
                    selectedMaterials += "Audio ";
                }

                String selectedDuration = spinnerDuration.getSelectedItem().toString();

                String confirmationDetails = "Level: " + selectedLevel + "\n" +
                        "Confirmed: " + isConfirmed + "\n" +
                        "Materials: " + selectedMaterials + "\n" +
                        "Duration: " + selectedDuration;

                Toast.makeText(confirm.this, confirmationDetails, Toast.LENGTH_SHORT).show();

                if (isConfirmed) {
                    // Show the dialog with the confirmation details
                    showSuccessDialog(confirmationDetails);

                    // Show toast or perform other actions
                    Toast.makeText(confirm.this, confirmationDetails, Toast.LENGTH_SHORT).show();
                } else {
                    // Show a dialog indicating confirmation is required
                    showConfirmationRequiredDialog();
                }
            }
        });
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

    private void showSuccessDialog(String confirmationDetails) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_confirm, null);
        builder.setView(dialogView);

        TextView textViewConfirmationDetails = dialogView.findViewById(R.id.textViewConfirmationDetails);
        textViewConfirmationDetails.setText(confirmationDetails);

        final AlertDialog dialog = builder.create();

        Button btnDismiss = dialogView.findViewById(R.id.btnDismiss2);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showConfirmationRequiredDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation Required")
                .setMessage("Please confirm your selection.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Dismiss the dialog or handle as needed
                        dialog.dismiss();
                    }
                })
                .show();
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
