package com.siadous.thomas.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextWeight;
    EditText editTextHeight;
    EditText editTextBMI;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonOnClick();
    }

    private void buttonOnClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextWeight = findViewById(R.id.editText_weight);
                editTextHeight = findViewById(R.id.editText_height);
                editTextBMI = findViewById(R.id.editText_BMI);
                textViewResult = findViewById(R.id.textView_category_result);

                String weight = editTextWeight.getText().toString();
                String height = editTextHeight.getText().toString();

                double doubleWeight = Double.parseDouble(weight);
                double doubleHeight = Double.parseDouble(height);
                double result = doubleWeight / ((doubleHeight)*(doubleHeight));
                String strResult = String.valueOf(result);
                editTextBMI.setText(strResult);

                if(result < 15) {
                    textViewResult.setText( "Very severely underweight");
                } else if (result < 16) {
                    textViewResult.setText( "Severely underweight");
                } else if (result < 18.5) {
                    textViewResult.setText( "Underweight");
                } else if (result < 25) {
                    textViewResult.setText( "Normal");
                } else if (result < 30) {
                    textViewResult.setText( "Overweight");
                } else if (result < 35) {
                    textViewResult.setText( "Obese Class 1 - Moderately Obese");
                } else if (result < 40) {
                    textViewResult.setText( "Obese Class 2 - Severely Obese");
                } else {
                    textViewResult.setText( "Obese Class 3 - Very Severely Obese");
                }
            }
        });
    }
}
