package com.example.tempcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View view){
        RadioButton toCelsius = findViewById(R.id.radioButtonCelsius);
        EditText input = findViewById(R.id.editTextInput);
        TextView output = findViewById(R.id.textViewOutput);

        if(input.length() == 0){
            Toast.makeText(this, "Forneça temperatura!", Toast.LENGTH_SHORT).show();
        }else{
            double inputNumber = Double.parseDouble(input.getText().toString());
            double outputNumber = 0;
            if(toCelsius.isChecked()){
                outputNumber = (inputNumber - 32) * 5 / 9;

                output.setText(String.format("Resultado: %.2f C",outputNumber));
            }else{
                outputNumber = inputNumber * 9 / 5 + 32;
                output.setText(String.format("Resultado: %.2f C",outputNumber));
            }
        }


    }
}