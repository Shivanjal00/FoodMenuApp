package com.example.foodmenuapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load

class MenuItemsAdapter(
    private val context: Context,
    private val menuItems: List<MenuItem>
) : BaseAdapter() {

    override fun getCount(): Int = menuItems.size

    override fun getItem(position: Int): Any = menuItems[position]

    override fun getItemId(position: Int): Long = menuItems[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)

        val item = menuItems[position]

        val itemNameTextView = view.findViewById<TextView>(R.id.tv_item_name)
        val itemDescriptionTextView = view.findViewById<TextView>(R.id.tv_item_description)
        val itemPriceTextView = view.findViewById<TextView>(R.id.tv_item_price)
        val itemImageView = view.findViewById<ImageView>(R.id.iv_item_image)

        itemNameTextView.text = item.name
        itemDescriptionTextView.text = item.description
        itemPriceTextView.text = "$${item.price}"

        // Load image using Coil
        item.image?.let { imageUrl ->
            itemImageView.load(imageUrl) {
                placeholder(R.drawable.place)  // Add a placeholder image in case loading fails
                error(R.drawable.error)        // Add an error image if the URL is invalid
            }
        }

        return view
    }
}

