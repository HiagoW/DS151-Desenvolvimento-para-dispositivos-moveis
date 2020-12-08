package com.example.bdstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentOperations studentOperations;
    ListView studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentOperations = new StudentOperations(getApplicationContext());
        studentOperations.open();

        studentsList = findViewById(R.id.listStudents);
        List values = studentOperations.getAllStudents();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        studentsList.setAdapter(adapter);
    }

    public void add(View view){
        EditText editTextStudentName = findViewById(R.id.editTextStudentName);
        Student student = studentOperations.addStudent(editTextStudentName.getText().toString());
        ArrayAdapter adapter = (ArrayAdapter)studentsList.getAdapter();
        adapter.add(student);
        editTextStudentName.setText("");
    }

    public void delete(View view){
        ArrayAdapter adapter = (ArrayAdapter) studentsList.getAdapter();
        Student student = null;

        if(studentsList.getAdapter().getCount() > 0){
            student = (Student) studentsList.getAdapter().getItem(0);
            studentOperations.deleteStudent(student);
            adapter.remove(student);
        }else{
            Toast.makeText(this,"Lista Vazia!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        studentOperations.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        studentOperations.open();
    }
}