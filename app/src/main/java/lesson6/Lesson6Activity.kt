package lesson6

import android.content.*
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.nastia.administrator.lessonitacademy.R
import android.content.Intent
import android.widget.Toast
import android.content.BroadcastReceiver
import android.support.v4.content.LocalBroadcastManager


class Lesson6Activity : AppCompatActivity() {

    lateinit var changeWifi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6)

        val intent = Intent(this, MyService::class.java)
        startService(intent)

        changeWifi = findViewById(R.id.wifi_switcher)
        changeWifi.setOnClickListener {

            val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            serviceConnector.setWifi(!mWifi.isConnected)
        }
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val status = intent.getBooleanExtra("wifiStatus", false)
            var mess = "off"
            if (status){
                mess="on"
            }
            //get the type of message from MyGcmListenerService 1 - lock or 0 -Unlock
            Toast.makeText(application, mess, Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        bindService(Intent(this, MyService::class.java),
                serviceConnector, Context.BIND_AUTO_CREATE)
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, IntentFilter("NOW"))
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnector)
        unregisterReceiver(broadcastReceiver)
    }

    private val serviceConnector = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        private lateinit var localBinder: MyService.LocalBinder

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            localBinder = service as MyService.LocalBinder
        }
        fun setWifi(state:Boolean){
            localBinder.service.wifiManager(state)
        }
    }
}