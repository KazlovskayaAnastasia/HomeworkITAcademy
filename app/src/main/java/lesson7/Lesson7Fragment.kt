package lesson7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastia.administrator.lessonitacademy.R

class Lesson7Fragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private var screenDto = generateData()
    private lateinit var adapter: OwlAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_lesson7, container, false)
        adapter = OwlAdapter(this.context!!)
        manager = LinearLayoutManager(context)
        recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler).apply{
            layoutManager = manager
            adapter = adapter
        }

        adapter.setElements(screenDto)

        return view
    }

    companion object {

        var list : MutableList<Owl> = mutableListOf()

        fun setInstance(owls: List<Owl>) : List<Owl> {

            if(!list.isEmpty()){
                list.clear()
            }
            list.addAll(owls)
            return list
        }
    }

    fun generateData():List<Owl>{
        return mutableListOf(
                Owl("", "Alex", 12),
                Owl("", "Alex1", 12),
                Owl("", "Alex2", 12),
                Owl("", "Alex3", 12),
                Owl("", "Alex4", 12),
                Owl("", "Alex5", 12)
        )
    }
}