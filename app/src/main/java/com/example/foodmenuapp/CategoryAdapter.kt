package com.example.foodmenuapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CategoryAdapter(
    private val context: Context,
    private val categories: List<String>
) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, categories) {

    private var selectedPosition: Int = -1 // Track the selected position

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged() // Notify the adapter to refresh the list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)

        textView.text = categories[position]

        // Change text appearance based on selection
        if (position == selectedPosition) {
            textView.setTextColor(context.getColor(android.R.color.black)) // Dark color
            textView.textSize = 18f // Increase size or set a bold typeface if preferred
        } else {
            textView.setTextColor(context.getColor(android.R.color.darker_gray)) // Default color
            textView.textSize = 14f // Normal size
        }

        return view
    }
}
