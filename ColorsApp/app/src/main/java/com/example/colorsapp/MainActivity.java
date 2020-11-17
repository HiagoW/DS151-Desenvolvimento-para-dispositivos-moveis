package com.example.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    TextView hexColor, color;
    String[] hexColorArray = {"00", "00", "00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redSeekBar = findViewById(R.id.seekBarRed);
        greenSeekBar = findViewById(R.id.seekBarGreen);
        blueSeekBar = findViewById(R.id.seekBarBlue);
        hexColor = findViewById(R.id.textViewHexColor);
        color = findViewById(R.id.textViewColor);

        redSeekBar.setOnSeekBarChangeListener(new EventSeek((byte)0));
        greenSeekBar.setOnSeekBarChangeListener(new EventSeek((byte)1));
        blueSeekBar.setOnSeekBarChangeListener(new EventSeek((byte)2));
        setColor("#" + hexColorArray[0] + hexColorArray[1] + hexColorArray[2]);
    }

    private void setColor(String str){
        hexColor.setText(str);
        color.setBackgroundColor(Color.parseColor(str));
    }

    private void setHexNumber(int progress, byte color) {
        String c = Integer.toHexString(progress);
        hexColorArray[color] = (c.length() == 2 ? "" : "0") + c;
        setColor("#" + hexColorArray[0] + hexColorArray[1] + hexColorArray[2]);
    }

    private class EventSeek implements SeekBar.OnSeekBarChangeListener {
        private byte color;

        public EventSeek(byte color){
            this.color = color;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            setHexNumber(i,color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}