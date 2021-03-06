package com.example.biscoitodasorte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    String[] frases = {
            "A vida trará coisas boas se tiveres paciência.",
            "Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você.",
            "Não compense na ira o que lhe falta na razão.",
            "Defeitos e virtudes são apenas dois lados da mesma moeda.",
            "A maior de todas as torres começa no solo.",
            "Não há que ser forte. Há que ser flexível.",
            "Gente todo dia arruma os cabelos, por que não o coração?",
            "Há três coisas que jamais voltam; a flecha lançada, a palavra dita e a oportunidade perdida.",
            "A juventude não é uma época da vida, é um estado de espírito.",
            "Podemos escolher o que semear, mas somos obrigados a colher o que plantamos."
    };
    int ultimaSorteada = -1;
    int sorteada = -1;
    TextView textViewFrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewFrase = findViewById(R.id.textViewFrase);
    }

    public void sortear(View view){
        while(sorteada == ultimaSorteada){
            sorteada = rand.nextInt(10);
        }
        ultimaSorteada=sorteada;
        textViewFrase.setText(frases[sorteada]);
    }
}