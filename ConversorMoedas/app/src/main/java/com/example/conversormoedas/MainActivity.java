package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton deReal, paraReal, deDolar, paraDolar, deEuro, paraEuro;
    EditText input;
    TextView resultadoView;
    double entrada, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deReal = findViewById(R.id.radioButtonDeReal);
        paraReal = findViewById(R.id.radioButtonParaReal);
        deDolar = findViewById(R.id.radioButtonDeDolar);
        paraDolar = findViewById(R.id.radioButtonParaDolar);
        deEuro = findViewById(R.id.radioButtonDeEuro);
        paraEuro = findViewById(R.id.radioButtonParaEuro);
        input = findViewById(R.id.editTextInput);
        resultadoView = findViewById(R.id.textViewValorConvertido);
    }

    public void converter(View view){
        if(input.getText().length() == 0){
            Toast.makeText(this, "Forneça um valor!",Toast.LENGTH_SHORT).show();
        }else {
            try{
                entrada = Double.valueOf(input.getText().toString());
            } catch (Exception e){
                Toast.makeText(this, "Erro na conversão do valor.",Toast.LENGTH_SHORT).show();
                return;
            }

            if (deReal.isChecked() && paraDolar.isChecked()) {
                resultado = entrada * 5.50;
            } else if (deReal.isChecked() && paraEuro.isChecked()) {
                resultado = entrada * 6.20;
            } else if (deDolar.isChecked() && paraReal.isChecked()) {
                resultado = entrada / 5.50;
            } else if (deDolar.isChecked() && paraEuro.isChecked()) {
                resultado = entrada * 1.13;
            } else if (deEuro.isChecked() && paraReal.isChecked()) {
                resultado = entrada / 6.50;
            } else if (deEuro.isChecked() && paraDolar.isChecked()) {
                resultado = entrada / 1.13;
            }else{
                return ;
            }

            resultadoView.setText(String.format("R$ %.2f",resultado));
        }
    }
}