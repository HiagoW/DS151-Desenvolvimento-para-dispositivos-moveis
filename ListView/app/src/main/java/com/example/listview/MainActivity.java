package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listPlaces;
    private String[] itens = {"SFS","Joinville","Curitiba"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPlaces = findViewById(R.id.listaLocais);
        ArrayAdapter<String> array = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                itens
        );
        listPlaces.setAdapter(array);

        listPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = listPlaces.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),"Selecionado " + selected, Toast.LENGTH_LONG).show();
            }
        });
    }
}