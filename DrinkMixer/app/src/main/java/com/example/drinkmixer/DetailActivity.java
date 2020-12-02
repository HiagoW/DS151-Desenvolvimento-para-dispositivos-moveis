package com.example.drinkmixer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int drinkId = 3;
        Intent it = getIntent();
        String[] ingredients =
                new String[]{"Ingrediente 1 \n Ingrediente 2 \n Ingrediente 3",
                "Ingrediente 4 \n Ingrediente 5 \n Ingrediente 6",
                "Ingrediente 7 \n Ingrediente 8 \n Ingrediente 9"};
        TextView nome = findViewById(R.id.textViewNome);
        TextView ingredientes = findViewById(R.id.textViewIngredientes);

        if(it!=null)
            drinkId = it.getIntExtra("drinkId",3);

        if(drinkId == 3){
            nome.setText("");
            ingredientes.setText("");
            Toast.makeText(this,"Drink não encontrado", Toast.LENGTH_SHORT).show();
        }else{
            nome.setText(MainActivity.drinks[drinkId]);
            ingredientes.setText(ingredients[drinkId]);
        }
    }
}