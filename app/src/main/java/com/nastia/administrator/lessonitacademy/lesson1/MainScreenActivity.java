package com.nastia.administrator.lessonitacademy.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nastia.administrator.lessonitacademy.R;

import lesson2.Lesson2Activity;
import lesson3.Lesson3Activity;
import lesson4.Lesson4Activity;

public class MainScreenActivity extends Activity {

    Button btnHw1;
    Button btnHw2;
    Button btnHw3;
    Button btnHw4;
    Button btnHw5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnHw1 = findViewById(R.id.btn_hw1);
        btnHw2 = findViewById(R.id.btn_hw2);
        btnHw3 = findViewById(R.id.btn_hw3);
        btnHw4 = findViewById(R.id.btn_hw4);
        btnHw5 = findViewById(R.id.btn_hw5);

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
                Toast toast = Toast.makeText(getApplicationContext(), "In process...", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
