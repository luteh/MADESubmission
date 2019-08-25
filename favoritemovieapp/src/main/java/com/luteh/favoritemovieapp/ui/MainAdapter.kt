package com.luteh.favoritemovieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luteh.favoritemovieapp.R
import com.luteh.favoritemovieapp.data.MovieData

/**
 * Created by Luthfan Maftuh on 8/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MainAdapter : RecyclerView.Adapter<MainHolder>() {

    private var dataSources: List<MovieData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return MainHolder(itemView)
    }

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSources(datas: List<MovieData>) {
        dataSources = datas
        notifyDataSetChanged()
    }
}