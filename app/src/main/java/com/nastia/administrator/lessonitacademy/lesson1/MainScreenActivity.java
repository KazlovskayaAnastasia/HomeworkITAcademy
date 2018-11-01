package com.nastia.administrator.lessonitacademy.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nastia.administrator.lessonitacademy.R;

import lesson10.Lesson10Activity;
import lesson2.Lesson2Activity;
import lesson3.Lesson3Activity;
import lesson4.Lesson4Activity;
import lesson5.Lesson5Activity;
import lesson6.Lesson6Activity;
import lesson7.Lesson7Activity;
import lesson9.Lesson9Activity;

public class MainScreenActivity extends Activity {

    Button btnHw1;
    Button btnHw2;
    Button btnHw3;
    Button btnHw4;
    Button btnHw5;
    Button btnHw6;
    Button btnHw7;
    Button btnHw9;
    Button btnHw10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnHw1 = findViewById(R.id.btn_hw1);
        btnHw2 = findViewById(R.id.btn_hw2);
        btnHw3 = findViewById(R.id.btn_hw3);
        btnHw4 = findViewById(R.id.btn_hw4);
        btnHw5 = findViewById(R.id.btn_hw5);
        btnHw6 = findViewById(R.id.btn_hw6);
        btnHw7 = findViewById(R.id.btn_hw7);
        btnHw9 = findViewById(R.id.btn_hw9);
        btnHw10 = findViewById(R.id.btn_hw10);

        btnHw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson1Activity.class);
                startActivity(intent);
            }
        });

        btnHw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson2Activity.class);
                startActivity(intent);
            }
        });

        btnHw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson3Activity.class);
                startActivity(intent);
            }
        });

        btnHw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
            }
        });

        btnHw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, Lesson5Activity.class);
                startActivity(intent);
            }
        });

        btnHw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, Lesson6Activity.class);
                startActivity(intent);
            }
        });

        btnHw7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson7Activity.class);
                startActivity(intent);
            }
        });

        btnHw9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson9Activity.class);
                startActivity(intent);
            }
        });

        btnHw10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreenActivity.this, Lesson10Activity.class);
                startActivity(intent);
            }
        });
    }
}
