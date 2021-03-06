package lesson4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.nastia.administrator.lessonitacademy.R;

public class Lesson4Activity extends Activity {

    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        iv1 = findViewById(R.id.image_view);
        CircleView circle = findViewById(R.id.circle);

        iv1.setBackgroundResource(R.drawable.owl_anim);
        AnimationDrawable animation = (AnimationDrawable)iv1.getBackground();

        animation.start();

        float[] data = {5, 5, 10};
        circle.setData(data);
    }
}
