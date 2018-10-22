package lesson7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import com.nastia.administrator.lessonitacademy.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import android.text.Editable
import android.text.TextWatcher

class Lesson7Fragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var owlAdapter: OwlAdapter
    private lateinit var addBtn: ImageButton
    private lateinit var searchOwl: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listItems = generateData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_lesson7, container, false)
        searchOwl = view.findViewById(R.id.et_search_owl)
        searchOwl.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                filter(editable.toString())
            }
        })
        addBtn = view.findViewById<ImageButton>(R.id.btn_add).apply {
            setOnClickListener {
                fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment, OwlDetailsFragment.newInstance(Owl("", "", 0), -1))?.commit()
            }
        }
        owlAdapter = OwlAdapter(this.context!!, object : OwlAdapter.OnItemSelectedListener {
            override fun itemSelected(position: Int) {
                fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment, OwlDetailsFragment.newInstance(listItems[position], position))?.commit()
            }
        })
                .apply {
                    setElements(listItems)
                }
        manager = LinearLayoutManager(context)
        recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler).apply {
            layoutManager = manager
            adapter = owlAdapter
        }
        return view
    }

    private fun filter(text: String) {
        val newList: MutableList<Owl> = mutableListOf()

        for (s in listItems) {
            if (s.name.toLowerCase().contains(text.toLowerCase())) {
                newList.add(s)
            }
        }
        owlAdapter.filterList(newList)
    }

    companion object {
        private var listItems: MutableList<Owl> = mutableListOf()
        fun getList() = listItems
    }

    private fun generateData(): MutableList<Owl> {

        val list: MutableList<Owl> = mutableListOf()
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val m_jArry = obj.getJSONArray("owls")
            for (i in 0 until m_jArry.length()) {
                val jo_inside = m_jArry.getJSONObject(i)
                val owl_name = jo_inside.getString("name")
                val owl_age = jo_inside.getInt("age")
                val url_pic = jo_inside.getString("picture")

                list.add(Owl(url_pic, owl_name, owl_age))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    private fun loadJSONFromAsset(): String {
        var json = ""
        try {
            val stream = context!!.assets.open("owls.json")
            val size = stream?.available()
            val buffer = size?.let { ByteArray(it) }
            stream?.read(buffer)
            stream?.close()
            json = buffer?.let { String(it) }.toString()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }
}