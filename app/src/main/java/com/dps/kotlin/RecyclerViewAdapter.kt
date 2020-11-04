package com.dps.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dps.R
import com.dps.model.SoftwareEngineer
import com.google.android.material.imageview.ShapeableImageView


class RecyclerViewAdapter
(
        private val softwareEngineerList: List<com.dps.kotlin.SoftwareEngineer>,
        private val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    // Each view holder is in charge of displaying a single item with a view for our awesome recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method is used for binding the data to it's position on the recycler view - check " position " parameter passed to it
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val softwareEngineer = softwareEngineerList[position]
        holder.name.text = softwareEngineer.name
        holder.title.text = softwareEngineer.title
        Glide.with(context).load(softwareEngineer.image).circleCrop().into(holder.image)
    }

    // This method return the counts for the while recycler view items
    override fun getItemCount(): Int {
        return softwareEngineerList.size
    }

    // cast views from the view holder
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var title: TextView
        var image: ShapeableImageView

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            name = view.findViewById<View>(R.id.name) as TextView
            image = view.findViewById<View>(R.id.image) as ShapeableImageView
        }
    }
}