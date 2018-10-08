package lesson5;

import android.app.Activity;
import android.os.Bundle;

import com.nastia.administrator.lessonitacademy.R;

public class Lesson5Activity extends Activity {
    private Thread thread;
    private ClockView timerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);
        timerView = (ClockView) findViewById(R.id.dz4_timer_view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        thread.interrupt();
    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (timerView.seconds < 60)
                                timerView.seconds++;
                            else {
                                timerView.seconds = 1;
                                if (timerView.minutes < 60)
                                    timerView.minutes++;
                                else {
                                    timerView.minutes = 1;
                                    if (timerView.hours < 12)
                                        timerView.hours++;
                                    else {
                                        timerView.hours = 1;
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        thread.interrupt();
    }
}
