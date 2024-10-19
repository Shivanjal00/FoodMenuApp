package com.example.foodmenuapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CategoryAdapter(
    context: Context,
    private val categories: List<String>
) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, categories) {

    private var selectedPosition = -1 // Track the selected position

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent) as TextView

        // Set default text color
        view.setTextColor(android.graphics.Color.BLACK) // Default color is black
        view.textSize = 16f // Set default text size

        // Check if the current position is selected
        if (position == selectedPosition) {
            view.setTypeface(view.typeface, android.graphics.Typeface.BOLD) // Make text bold if selected
        } else {
            view.setTypeface(view.typeface, android.graphics.Typeface.NORMAL) // Normal text otherwise
        }

        return view
    }

    // Method to update the selected position
    fun setSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged() // Notify the adapter to refresh the view
    }
}
