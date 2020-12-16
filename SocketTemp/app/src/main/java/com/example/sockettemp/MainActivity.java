package com.example.sockettemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View view){
        EditText temp = findViewById(R.id.editTextNumberDecimal);
        TextView out = findViewById(R.id.textViewOut);

        Double tempC = Double.parseDouble(temp.getText().toString());
        RequestTask tasks = new RequestTask(out);
        tasks.execute(tempC);
    }
}