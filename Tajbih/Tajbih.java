package com.JannatiSobdo.nur_e_quran.App.Tajbih;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.JannatiSobdo.nur_e_quran.R;

public class Tajbih extends AppCompatActivity {

    RelativeLayout minus, plus, reset;
    int Count = 0;
    TextView TextCount;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajbih);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        reset = findViewById(R.id.reset);
        TextCount = findViewById(R.id.TextCount);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int Tajbih = sharedPreferences.getInt("Tajbih", 0);

        TextCount.setText(Tajbih+"");

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                TextCount.setText(Count+"");
                setTajbihVoid();
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Count>0){
                    Count--;
                }
                TextCount.setText(Count+"");
                setTajbihVoid();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = 0;
                TextCount.setText(Count+"");
                setTajbihVoid();
            }
        });

    }

    private void setTajbihVoid() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Tajbih", Count);
        editor.apply();
    }
}