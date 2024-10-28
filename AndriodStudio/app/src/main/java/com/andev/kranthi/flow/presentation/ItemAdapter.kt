package com.andev.kranthi.flow.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andev.kranthi.R
import com.andev.kranthi.flow.data.model.SampleData

class ItemAdapter (private val items: List<SampleData>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idTextView: TextView = itemView.findViewById(R.id.item_id)
        private val userIdTextView: TextView = itemView.findViewById(R.id.item_useId)
        private val titleTextView: TextView = itemView.findViewById(R.id.item_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.item_description)

        fun bind(item: SampleData) {
//            idTextView.text = item.id.toString()
            userIdTextView.text = item.userId.toString()
            titleTextView.text = item.title.toString()
            descriptionTextView.text = item.body.toString()
        }
    }
}