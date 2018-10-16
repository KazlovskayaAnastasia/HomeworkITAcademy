package lesson7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nastia.administrator.lessonitacademy.R

class Lesson7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson7)

        supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.add(R.id.fragment, Lesson7Fragment())?.commit()
    }
}