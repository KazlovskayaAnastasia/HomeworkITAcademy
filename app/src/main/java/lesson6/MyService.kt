package lesson6

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    private val mBinder = LocalBinder()
    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("Sevice", "onStartCommand(intent, flags, startId)")
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    inner class LocalBinder : Binder() {
        val service: MyService
            get() = this@MyService
    }

    fun wifiManager(status: Boolean){

        val wifi = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifi.isWifiEnabled = status
    }

    internal var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            val intent = Intent()
            intent.putExtra("wifiStatus", mWifi.isConnected)
            intent.action = "NOW"
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
        }
    }
}

