package com.nastia.administrator.lessonitacademy.lesson1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.nastia.administrator.lessonitacademy.R;
import com.bumptech.glide.Glide;


public class Lesson3Activity extends Activity {

    EditText et_get_link;
    Button btn_get_image;
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        et_get_link = findViewById(R.id.et_link);
        btn_get_image = findViewById(R.id.btn_get_image);
        iv_image = findViewById(R.id.iv_image);

        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_image.setVisibility(View.VISIBLE);
                Glide.with(Lesson3Activity.this).load(et_get_link.getText()).into(iv_image);


            }
        });
    }
}
