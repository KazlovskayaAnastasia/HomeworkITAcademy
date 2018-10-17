package lesson7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.nastia.administrator.lessonitacademy.R
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception

class Lesson7Fragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private var screenDto = generateData()
    private lateinit var owlAdapter: OwlAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_lesson7, container, false)
        owlAdapter = OwlAdapter(this.context!!, object : OwlAdapter.OnItemSelectedListener {
            override fun itemSelected(position: Int) {
                fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment, OwlDetailsFragment.newInstance(screenDto[position]))?.commit()
            }
        })
                .apply {
                    setElements(screenDto)
                }
        manager = LinearLayoutManager(context)
        recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler).apply {
            layoutManager = manager
            adapter = owlAdapter
        }

        return view
    }

    companion object {

        var list: MutableList<Owl> = mutableListOf()

        fun setInstance(owls: List<Owl>): List<Owl> {

            if (!list.isEmpty()) {
                list.clear()
            }
            list.addAll(owls)
            return list
        }
    }

    private fun generateData(): List<Owl> {

        val parser = JsonParser()
        val list: MutableList<Owl> = mutableListOf()
//        try {
//            val inStr =InputStreamReader(context!!.assets.open("json"))
//            val buffer = BufferedReader(inStr)
//            val gson = Gson()
//            val rootObj = gson.fromJson(buffer,List<Owl>())
////            val rootObj = parser.parse(FileReader("owls.json")).asJsonObject
//            val jsonArray = rootObj.get("owls").asJsonArray
//
//            for (i in jsonArray) {
//                val item: JsonObject = jsonArray.get(jsonArray.indexOf(i)).asJsonObject
//                val singleOwl: Owl = Owl(item.get("picture").asString, item.get("name").asString, item.get("age").asInt)
//                list.add(singleOwl)
//            }
//
//        } catch (e: Exception) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
//        }




        return mutableListOf(
                Owl("", "Alex", 12),
                Owl("", "Max", 5),
                Owl("", "Alice", 18),
                Owl("", "Michael", 3),
                Owl("", "Tim", 10),
                Owl("", "Dori", 16),
                Owl("", "Mary", 10),
                Owl("", "Henry", 11)
        )
//        return  list
    }
}