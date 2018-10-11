package lesson6

import android.annotation.TargetApi
import android.content.*
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.nastia.administrator.lessonitacademy.R



class Lesson6Activity : AppCompatActivity() {

    lateinit var changeWifi: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_lesson6)
    }

    var receiver: BroadcastReceiver = object : BroadcastReceiver() {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onReceive(context: Context, intent: Intent) {

            val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            if (mWifi.isConnected) {
                wifiManager(true)
                changeWifi.background = getDrawable(R.color.green)
            } else {
                wifiManager(false)
                changeWifi.background = getDrawable(R.color.red)
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()

        bindService(Intent(this, MyService::class.java),
                serviceConnector, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnector)
        unregisterReceiver(receiver)
    }

    private val serviceConnector = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        }
    }

    fun wifiManager(status: Boolean){
        val wifiManager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (status && !wifiManager.isWifiEnabled) {
            wifiManager.isWifiEnabled = true
        } else if (!status && wifiManager.isWifiEnabled) {
            wifiManager.isWifiEnabled = false
        }
    }
}