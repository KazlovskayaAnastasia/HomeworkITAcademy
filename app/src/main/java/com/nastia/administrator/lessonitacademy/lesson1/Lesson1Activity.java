package com.nastia.administrator.lessonitacademy.lesson1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nastia.administrator.lessonitacademy.R;

public class Lesson1Activity extends Activity implements View.OnClickListener {

    TextView tv1;
    TextView tv2;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView1);
        btnChange = findViewById(R.id.btn_change);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = tv1.getText().toString();
                tv1.setText(tv2.getText());
                tv2.setText(temp);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable color = tv1.getBackground();
                tv1.setBackground(tv2.getBackground());
                tv2.setBackground(color);
            }
        };
        tv1.setOnClickListener(listener);

        tv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Drawable color = tv1.getBackground();
        tv1.setBackground(tv2.getBackground());
        tv2.setBackground(color);
    }
}
