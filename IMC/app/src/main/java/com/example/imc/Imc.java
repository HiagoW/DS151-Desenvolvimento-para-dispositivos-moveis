package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Imc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewImc = findViewById(R.id.textViewImc);
        TextView textViewStatus = findViewById(R.id.textViewStatus);
        Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if(params!=null){
                String name = params.getString("name");
                Double imc = params.getDouble("imc");
                textViewName.setText(name);
                textViewImc.setText(String.format("%.2f",imc));
                textViewStatus.setText(status(params.getDouble("imc")));
            }
        }
    }

    String status(Double imc){
        String msg;
        if(imc < 15){
            msg = "Extremamente abaixo do peso";
        }else if(imc >= 15 && imc < 16){
            msg = "Gravemente abaixo do peso";
        }else{
            msg = "Acima do peso";
        }
        return msg;
    }
}