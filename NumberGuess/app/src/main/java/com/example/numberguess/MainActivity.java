package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r;
    int num, tries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        num = r.nextInt(100)+1;
        tries = 0;
        System.out.println(num);
    }

    public void guess(View view) {
        EditText input = findViewById(R.id.editTextInput);
        TextView output = findViewById(R.id.textViewOutput);

        if(input.length()==0)
            Toast.makeText(this,"Forneça o número!",Toast.LENGTH_SHORT).show();
        else {

            int inputNumber = Integer.parseInt(input.getText().toString());
            tries++;
            String tip;
            if (num > inputNumber) {
                tip = "Número sorteado é maior!";
            } else if (num < inputNumber) {
                tip = "Número sorteado é menor!";
            } else {
                tip = "Acertou! \n Você usou " + tries + " tentativas.";
            }
            output.setText(tip);
        }
    }
}