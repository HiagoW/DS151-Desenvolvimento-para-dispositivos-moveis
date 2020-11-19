package com.example.churrascometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbHomens, sbMulheres;
    TextView tvLinguica, tvCarne, tvHomens, tvMulheres;
    double kgsLinguica, kgsCarne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sbHomens = findViewById(R.id.seekBarHomens);
        sbMulheres = findViewById(R.id.seekBarMulheres);
        tvLinguica = findViewById(R.id.textViewLinguica);
        tvCarne = findViewById(R.id.textViewCarne);
        tvHomens = findViewById(R.id.textViewQtdHomens);
        tvMulheres = findViewById(R.id.textViewQtdMulheres);
        calcula(1,2);
        sbMulheres.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvMulheres.setText(String.valueOf(i));
                calcula(sbHomens.getProgress(),i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbHomens.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvHomens.setText(String.valueOf(i));
                calcula(i, sbMulheres.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcula(int homens, int mulheres){
        kgsCarne = homens*0.450+mulheres*0.300;
        kgsLinguica = homens*0.250+mulheres*0.150;
        tvLinguica.setText(String.format("%.2f Kgs",kgsLinguica));
        tvCarne.setText(String.format("%.2f Kgs",kgsCarne));
    }
}