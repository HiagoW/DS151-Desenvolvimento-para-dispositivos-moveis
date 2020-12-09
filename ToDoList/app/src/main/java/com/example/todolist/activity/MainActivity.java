package com.example.todolist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.todolist.R;
import com.example.todolist.helper.RecyclerItemClickListener;
import com.example.todolist.helper.ToDoDAO;
import com.example.todolist.model.ToDo;
import com.example.todolist.adapter.ToDoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ToDoAdapter toDoAdapter;
    private List<ToDo> toDoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewToDoList);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ToDo selectedToDo = toDoList.get(position);

                                Intent intent = new Intent(MainActivity.this, AddToDoActivity.class);
                                intent.putExtra("selectedToDo", selectedToDo);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                ToDo selectedToDo = toDoList.get(position);
                                AlertDialog.Builder dialog =
                                        new AlertDialog.Builder(MainActivity.this);
                                dialog.setTitle("Confirmar Exclusão?");
                                dialog.setMessage("Deseja excluir a tarefa: "+selectedToDo.getToDoName()+
                                        "?");
                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        ToDoDAO toDoDAO = new ToDoDAO(getApplicationContext());
                                        if(toDoDAO.deleteToDo(selectedToDo)){
                                            updateRecyclerToDo();
                                            Toast.makeText(MainActivity.this,"Tarefa excluida.",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this,"Erro ao excluir tarefa.",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.setNegativeButton("Não",null);
                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );
    }

    public void updateRecyclerToDo(){
        ToDoDAO toDoDAO = new ToDoDAO(getApplicationContext());
        toDoList = toDoDAO.getAllToDos();

        toDoAdapter = new ToDoAdapter(toDoList);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(toDoAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateRecyclerToDo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infla menu em tempo real
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_add){
            Intent intent = new Intent(getApplicationContext(), AddToDoActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}