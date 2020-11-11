package com.example.cambio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){
        EditText dolarView = findViewById(R.id.editTextNumberDecimal);
        TextView realView = findViewById(R.id.textView);
        double dolar;
        try{
            dolar = Double.parseDouble(dolarView.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Forneça um número real",Toast.LENGTH_SHORT).show();
            return ;
        }
        double real = dolar * 5.41;
        realView.setText(String.valueOf(real));
    }
}