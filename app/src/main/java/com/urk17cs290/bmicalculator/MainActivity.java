package com.urk17cs290.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bob= findViewById((R.id.button));
        final EditText weight= findViewById(R.id.weight);
        final EditText height= findViewById(R.id.height);
        final TextView bmiView = findViewById(R.id.bmi);
        final TextView statusView = findViewById(R.id.status);
        bob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double myHeight = Double.parseDouble(height.getText().toString());
                double myWeight = Double.parseDouble(weight.getText().toString());
                double bmi = (myWeight / (myHeight * myHeight))*10000 ;
                String value = "";
                if (bmi > 30.00) {
                    value = "obese";
                } else if (bmi >= 25.00 && bmi < 30.00) {
                    value = "overweight";
                } else if (bmi >= 20.00 && bmi < 25.00) {
                    value = "normal";
                } else if (bmi < 20.00) {
                    value = "underweight";
                }
                bmiView.setText(String.format("Your bmi is %s", Math.round(bmi)));
                statusView.setText(String.format(" Your Category: %s", value));

                Toast.makeText(getApplicationContext(), "Category :" + value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}