package com.example.soma;

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

    public void somar (View view){
        EditText n1View = findViewById(R.id.editTextNumber);
        EditText n2View = findViewById(R.id.editTextNumber2);
        TextView resultadoView = findViewById(R.id.textView);
        int resultado;
        try{
            int n1 = Integer.parseInt(n1View.getText().toString());
            int n2 = Integer.parseInt(n2View.getText().toString());
            resultado = n1+n2;
        }catch (Exception e){
            Toast.makeText(this,"Erro ao realizar a soma",Toast.LENGTH_SHORT).show();
            return ;
        }
        resultadoView.setText(String.valueOf(resultado));
    }
}