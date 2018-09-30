package lesson4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class CircleView extends View {

    public int circleColor = Color.BLUE;
    private Paint paint;
    private float[] data;

    public CircleView(Context context) {
        super(context);
        init();

    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(circleColor);
    }

    public void setData(float[] data){
        this.data = data;
        invalidate();
    }

    private float[] pieSegment(){
        float[] segValues = new float[this.data.length];
        float Total = getTotal();
        for(int i = 0; i<this.data.length; i++){
            segValues[i] = (this.data[i]/Total) * 360;
        }
        return segValues;
    }

    private float getTotal(){
        float total = 0;
        for (float val: this.data){
            total += val;
        }
        return total;
    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(data!=null){
            int top = 0;
            int left = 0;
            int endBottom = getHeight();
            int endRight = endBottom;
            RectF rectF = new RectF(left, top, endRight, endBottom);
            float[] segment = pieSegment();
            float segStartPoint = 0;
            for (float aSegment : segment) {
                Random rnd = new Random();
                int color = Color.argb(255, (int) aSegment, rnd.nextInt(256), rnd.nextInt(256));
                paint.setColor(color);
                canvas.drawArc(rectF, segStartPoint, aSegment, true, paint);
                segStartPoint += aSegment;
            }
        }
    }
}
