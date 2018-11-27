package lesson16

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.nastia.administrator.lessonitacademy.R
import kotlinx.android.synthetic.main.activity_lesson16.*

class Lesson16Activity : AppCompatActivity() {

    lateinit var avatar : RelativeLayout
    lateinit var tv_arrow_avatar : View
    lateinit var tv_prompt_avatar : TextView
    lateinit var buttons : LinearLayout
    lateinit var btn_delete : TextView
    lateinit var btn_save : TextView
    lateinit var btn_got_it : Button
    lateinit var darkView : View
    lateinit var tv_arrow_btn_delete : View
    lateinit var tv_prompt_btn_delete : TextView
    lateinit var tv_arrow_btn_save : View
    lateinit var tv_prompt_btn_save : TextView
    lateinit var welcome_text : TextView
    lateinit var btn_get : Button
    lateinit var btn_not_now : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson16)

        avatar = findViewById(R.id.avatar)
        tv_arrow_avatar = findViewById(R.id.arrow_avatar)
        tv_prompt_avatar = findViewById(R.id.prompt_avatar)
        buttons = findViewById(R.id.buttons)
        btn_delete = findViewById(R.id.btn_user_delete)
        btn_save = findViewById(R.id.btn_user_save)
        btn_got_it = findViewById(R.id.btn_got_it)
        darkView = findViewById(R.id.dark_view)
        tv_arrow_btn_delete = findViewById(R.id.arrow_btn_delete)
        tv_prompt_btn_delete = findViewById(R.id.prompt_btn_delete)
        tv_arrow_btn_save = findViewById(R.id.arrow_btn_save)
        tv_prompt_btn_save = findViewById(R.id.prompt_btn_save)
        welcome_text = findViewById(R.id.tv_welcome_text)
        btn_get = findViewById(R.id.btn_get)
        btn_not_now = findViewById(R.id.btn_not_now)

        darkView.visibility = View.VISIBLE
        welcome_text.bringToFront()
        btn_get.bringToFront()
        btn_not_now.bringToFront()

        btn_not_now.setOnClickListener {
            darkView.visibility = View.GONE
            welcome_text.visibility = View.GONE
            btn_get.visibility = View.GONE
            btn_not_now.visibility = View.GONE
        }

        btn_get.setOnClickListener {
            darkView.visibility = View.VISIBLE
            darkView.bringToFront()
            tv_arrow_btn_delete.visibility = View.VISIBLE
            tv_arrow_btn_delete.bringToFront()
            tv_prompt_btn_delete.visibility = View.VISIBLE
            tv_prompt_btn_delete.bringToFront()
            btn_save.visibility = View.INVISIBLE
            buttons.bringToFront()
            btn_got_it.visibility = View.VISIBLE
            btn_got_it.bringToFront()
            welcome_text.visibility = View.GONE
            btn_get.visibility = View.GONE
            btn_not_now.visibility = View.GONE

        }

        var currentStep = 1

        btn_got_it.setOnClickListener {

            when (currentStep) {
                1 -> {
                    tv_arrow_btn_delete.visibility = View.GONE
                    tv_prompt_btn_delete.visibility = View.GONE
                    btn_user_delete.visibility = View.INVISIBLE
                    btn_save.visibility = View.VISIBLE
                    buttons.bringToFront()
                    tv_arrow_btn_save.visibility = View.VISIBLE
                    tv_arrow_btn_save.bringToFront()
                    tv_prompt_btn_save.visibility = View.VISIBLE
                    tv_prompt_btn_save.bringToFront()
                    btn_got_it.visibility = View.VISIBLE
                    btn_got_it.bringToFront()
                    currentStep = 2
                }
                2 -> {
                    tv_arrow_btn_save.visibility = View.GONE
                    tv_prompt_btn_save.visibility = View.GONE
                    btn_save.visibility = View.VISIBLE
                    btn_user_delete.visibility = View.VISIBLE
                    buttons.visibility = View.VISIBLE
                    darkView.bringToFront()
                    avatar.bringToFront()
                    tv_prompt_avatar.visibility = View.VISIBLE
                    tv_prompt_avatar.bringToFront()
                    tv_arrow_avatar.visibility = View.VISIBLE
                    tv_arrow_avatar.bringToFront()
                    btn_got_it.visibility = View.VISIBLE
                    btn_got_it.bringToFront()
                    btn_got_it.text = "Finish"
                    currentStep = 3
                }
                3 -> {
                    darkView.visibility = View.GONE
                    tv_arrow_avatar.visibility = View.GONE
                    tv_prompt_avatar.visibility = View.GONE
                    btn_got_it.visibility = View.GONE
                }
            }
        }
    }
}