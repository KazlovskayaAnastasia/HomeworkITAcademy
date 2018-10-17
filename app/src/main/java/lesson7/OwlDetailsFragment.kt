package lesson7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.nastia.administrator.lessonitacademy.R

class OwlDetailsFragment : Fragment() {

    private lateinit var iv_pic : ImageView
    private lateinit var et_name : EditText
    private lateinit var et_age : EditText

    lateinit var bundle :Bundle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_owl_details, container, false)

        iv_pic = view.findViewById(R.id.image_details)
        et_name = view.findViewById(R.id.et_name_details)
        et_age = view.findViewById(R.id.et_age_details)

        et_name.setText(bundle.getString(KEY_NAME))
        et_age.setText(bundle.getInt(KEY_AGE).toString())
        return view
    }

    companion object {
        const val KEY_PIC = "Pic"
        const val KEY_NAME = "Name"
        const val KEY_AGE = "Age"
        fun newInstance(data: Owl): OwlDetailsFragment {
            val bundle = Bundle()
            bundle.putString(KEY_PIC, data.pic)
            bundle.putString(KEY_NAME, data.name)
            bundle.putInt(KEY_AGE, data.age)

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