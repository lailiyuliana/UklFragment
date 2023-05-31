package com.example.ukl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment(), View.OnClickListener {
    lateinit var adapter: Adapter
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dikirim.text = "dikirim ke " + arguments?.getString("email")
        change_layout.setOnClickListener(this)

        var data = ArrayList<Item>()
        data.addAll(ItemData().listData)
        recycler.layoutManager = GridLayoutManager(context,2)
        adapter = Adapter(data)
        listAdapter = ListAdapter(data)
        recycler.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = Home()
    }

    override fun onClick(p0: View?) {
        if(recycler.adapter == adapter){
            change_layout.setBackgroundResource(R.drawable.ic_baseline_grid_on_24)
            recycler.adapter = listAdapter
            recycler.layoutManager = LinearLayoutManager(context)
        }
        else if(recycler.adapter == listAdapter){
            change_layout.setBackgroundResource(R.drawable.ic_baseline_format_list_bulleted_24)
            recycler.adapter = adapter
            recycler.layoutManager = GridLayoutManager(context, 2)
        }
    }
}