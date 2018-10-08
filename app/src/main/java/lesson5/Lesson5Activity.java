package lesson5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;

import com.nastia.administrator.lessonitacademy.R;

public class Lesson5Activity extends Activity {
    private Thread thread;
    private ClockView timerView;
    private TextView tv_statusWifi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);
        timerView = (ClockView) findViewById(R.id.dz4_timer_view);
        tv_statusWifi = findViewById(R.id.wifi_status);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (mWifi.isConnected()) {
                tv_statusWifi.setText("Wifi status ON");
            } else{
                tv_statusWifi.setText("Wifi status OFF");
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        thread.interrupt();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
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
        unregisterReceiver(receiver);
        thread.interrupt();
    }
}
