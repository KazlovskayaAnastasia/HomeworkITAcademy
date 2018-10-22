package lesson7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nastia.administrator.lessonitacademy.R

class OwlDetailsFragment : Fragment() {

    private lateinit var iv_pic: ImageView
    private lateinit var et_name: EditText
    private lateinit var et_age: EditText
    private lateinit var btnSave: TextView
    private lateinit var btnDelete: TextView

    lateinit var bundle: Bundle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_owl_details, container, false)

        iv_pic = view.findViewById(R.id.image_details)

        if (!bundle.getString(KEY_PIC)!!.isEmpty()) {
            Glide.with(this).load(bundle.getString(KEY_PIC)).into(iv_pic)
        } else {
            iv_pic.setImageDrawable(context!!.resources.getDrawable(R.drawable.sova_anmation_1))
        }

        et_name = view.findViewById(R.id.et_name_details)
        et_age = view.findViewById(R.id.et_age_details)
        btnSave = view.findViewById<TextView>(R.id.btn_save).apply {
            if (bundle.getInt(KEY_POS) == -1) {
                text = "Add"
                setOnClickListener {
                    Lesson7Fragment.getList().add(Owl("", et_name.text.toString(), et_age.text.toString().toInt()))
                    activity?.onBackPressed()
                }
            } else {
                setOnClickListener {
                    Lesson7Fragment.getList()[bundle.getInt(KEY_POS)] = Owl(bundle.getString(KEY_PIC)!!, et_name.text.toString(), et_age.text.toString().toInt())
                    activity?.onBackPressed()
                }
            }
        }
        btnDelete = view.findViewById<TextView>(R.id.btn_delete).apply {
            if (bundle.getInt(KEY_POS) == -1) {
                text = "Cancel"
                setOnClickListener {
                    activity?.onBackPressed()
                }
            } else {
                setOnClickListener {
                    Lesson7Fragment.getList().removeAt(bundle.getInt(KEY_POS))
                    activity?.onBackPressed()
                }
            }
        }

        et_name.setText(bundle.getString(KEY_NAME))
        et_age.setText(bundle.getInt(KEY_AGE).toString())

        return view
    }

    companion object {
        const val KEY_PIC = "Pic"
        const val KEY_NAME = "Name"
        const val KEY_AGE = "Age"
        const val KEY_POS = "Position"
        fun newInstance(data: Owl, pos: Int): OwlDetailsFragment {
            val bundle = Bundle()
            bundle.putString(KEY_PIC, data.pic)
            bundle.putString(KEY_NAME, data.name)
            bundle.putInt(KEY_AGE, data.age)
            bundle.putInt(KEY_POS, pos)

            val fragment = OwlDetailsFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bundle = this.arguments!!
    }
}