package com.example.download;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText url;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        url = findViewById(R.id.editTextURL);
        url.setText("https://www.google.com/logos/doodles/2020/december-holidays-day-1-6753651837108829.4-law.gif");
    }

    public void eventHandler (View view){
        DownloadTask downloadTask = new DownloadTask(MainActivity.this,imageView);
        downloadTask.execute(url.getText().toString());
    }
}