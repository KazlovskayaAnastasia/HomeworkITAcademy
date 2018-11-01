package lesson10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.nastia.administrator.lessonitacademy.R

class Lesson10Activity : AppCompatActivity() {

    lateinit var btn_mary : Button
    lateinit var btn_max : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson10)

        btn_mary = findViewById(R.id.btn_mary)
        btn_max = findViewById(R.id.btn_max)

        btn_mary.setOnClickListener {
            supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment_les10, Lesson10Fragment.femaleInstance())?.commit()
        }

        btn_max.setOnClickListener {
            supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment_les10, Lesson10Fragment.maleInstance())?.commit()
        }
    }
}