package com.frotcom.searchtools

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frotcom.searchtools.SearchViewExample.SearchAndroid
import com.frotcom.searchtools.SearchViewExample.SearchAndroid.Companion.movieNamesArrayList
import java.util.*

class SearchAdapter(ctx: Context, val imageModelArrayList: ArrayList<SearchModel>) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater
    private val arraylist: ArrayList<SearchModel>

    init {

        inflater = LayoutInflater.from(ctx)
        this.arraylist = ArrayList<SearchModel>()
        this.arraylist.addAll(imageModelArrayList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.time.setText(imageModelArrayList[position].getNames())
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        imageModelArrayList.clear()
        if (charText.length == 0) {
            imageModelArrayList.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.getNames().toLowerCase(Locale.getDefault()).contains(charText)) {
                    imageModelArrayList.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: TextView

        init {

            time = itemView.findViewById(R.id.text_view1) as TextView
        }

    }


}