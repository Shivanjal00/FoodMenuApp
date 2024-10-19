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
        val itemIngredientsTextView = view.findViewById<TextView>(R.id.tv_item_ingredients)
        val itemSpicyVegTextView = view.findViewById<TextView>(R.id.tv_item_spicy_veg)
        val itemImageView = view.findViewById<ImageView>(R.id.iv_item_image)

        // Set the item fields
        itemNameTextView.text = item.name
        itemDescriptionTextView.text = if (item.description.isNotEmpty()) item.description else "No description available"

        // Directly use the price from the MenuItem
        itemPriceTextView.text = "${item.price}"  // item.price is now a String

        // Show ingredients
        val ingredientsString = if (item.ingredients.isNotEmpty()) {
            "Ingredients: ${item.ingredients.joinToString(", ")}"
        } else {
            "No ingredients listed"
        }
        itemIngredientsTextView.text = ingredientsString

        // Display spicy and vegetarian status
        val spicyText = if (item.spicy) "Spicy" else "Not Spicy"
        val vegetarianText = if (item.vegetarian) "Vegetarian" else "Non-Vegetarian"
        val spicyVegString = "$spicyText / $vegetarianText"
        itemSpicyVegTextView.text = spicyVegString

        // Load image using Coil
        item.image?.let { imageUrl ->
            itemImageView.load(imageUrl) {
                placeholder(R.drawable.place)  // Placeholder image
                error(R.drawable.error)        // Error image if URL fails
            }
        }

        return view
    }



}

