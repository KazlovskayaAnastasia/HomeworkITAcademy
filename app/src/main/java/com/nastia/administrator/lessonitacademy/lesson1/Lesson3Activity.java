package com.nastia.administrator.lessonitacademy.lesson1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.nastia.administrator.lessonitacademy.R;
import com.bumptech.glide.Glide;


public class Lesson3Activity extends Activity {

    EditText et_get_link;
    Button btn_get_image;
    ImageView iv_image;
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        et_get_link = findViewById(R.id.et_link);
        btn_get_image = findViewById(R.id.btn_get_image);
        iv_image = findViewById(R.id.iv_image);
        progress_bar = findViewById(R.id.progress);

        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress_bar.setVisibility(View.VISIBLE);

                Glide.with(Lesson3Activity.this)
                        .load(et_get_link.getText().toString())

                                .listener(new RequestListener<Drawable>() {

                                    @Override
                                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                                Target<Drawable> target, boolean isFirstResource) {
                                        progress_bar.setVisibility(View.GONE);
                                        return false;
                                    }

                                    @Override
                                    public boolean onResourceReady(Drawable resource, Object model,
                                                                   Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                        progress_bar.setVisibility(View.GONE);
                                        return false;
                                    }
                                })

                                .apply(RequestOptions.circleCropTransform())

                                .into(iv_image);
            }
        });
    }
}
