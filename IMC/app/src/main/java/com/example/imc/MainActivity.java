package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        EditText name = findViewById(R.id.editTextName);
        EditText weight = findViewById(R.id.editTextWeight);
        EditText height = findViewById(R.id.editTextHeight);

        String namePerson = name.getText().toString();
        Double weightPerson = Double.parseDouble(weight.getText().toString());
        Double heightPerson = Double.parseDouble(height.getText().toString());
        double imc = weightPerson / heightPerson * heightPerson;

        Intent it = new Intent(this, Imc.class);
        Bundle params = new Bundle();
        params.putString("name",namePerson);
        params.putDouble("imc",imc);
        it.putExtras(params);
        startActivity(it);
    }
}