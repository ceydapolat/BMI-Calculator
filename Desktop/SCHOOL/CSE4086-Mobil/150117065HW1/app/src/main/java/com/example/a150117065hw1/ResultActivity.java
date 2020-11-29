package com.example.a150117065hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView text_bmi, text_interpretation;
    Button button_calculate_again;
    String interpretation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        text_bmi = findViewById(R.id.text_bmi);
        text_interpretation = findViewById(R.id.text_interpretation);
        button_calculate_again = findViewById(R.id.button_calculate_again);

        double bmi = getIntent().getDoubleExtra("bmi_result", 5);

        if (bmi < 18.5) {
            interpretation = "underweight";
        } else if (bmi < 25) {
            interpretation = "normal";
        } else if (bmi < 30) {
            interpretation = "overweight";
        } else if (bmi >= 30) {
            interpretation = "obese";
        }

        text_bmi.setText("Your BMI is " + bmi);
        text_interpretation.setText("This is considered " + interpretation + ".");

        button_calculate_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}