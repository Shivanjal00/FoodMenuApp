package com.example.foodmenuapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var categoriesListView: ListView
    private lateinit var menuItemsListView: ListView
    private val categories = listOf("Pizza", "Dessert")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoriesListView = findViewById(R.id.lv_categories)
        menuItemsListView = findViewById(R.id.lv_menu_items)

        // Set up categories list
        val categoriesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        categoriesListView.adapter = categoriesAdapter

        // Sample JSON data
        val jsonString = """
            {
  "pizza": [
    {
      "id": 0,
      "name": "Margherita",
      "description": "A classic pizza with tomato and mozzarella",
      "ingredients": ["tomato sauce", "mozzarella"],
      "spicy": false,
      "vegetarian": true,
      "price": 17.0,
      "image": "https://i.imgur.com/8B8YLOo.jpg"
    },
    {
      "id": 1,
      "name": "Pepperoni",
      "description": "Pepperoni with mozzarella",
      "ingredients": ["tomato sauce", "mozzarella", "pepperoni"],
      "spicy": false,
      "vegetarian": false,
      "price": 20.0,
      "image": "https://i.imgur.com/OHHctnf.jpg"
    }
  ],
  "dessert": [
    {
      "id": 0,
      "name": "Brownie",
      "description": "Chocolate and hazelnut brownie",
      "ingredients": ["chocolate", "hazelnut"],
      "spicy": false,
      "vegetarian": true,
      "price": 15.0,
      "image": "https://i.imgur.com/7WbfaDN.png"
    },
    {
      "id": 1,
      "name": "Cheesecake",
      "description": "Creamy cheesecake with berry topping",
      "ingredients": ["cheese", "berries"],
      "spicy": false,
      "vegetarian": true,
      "price": 12.0,
      "image": "https://i.imgur.com/AsldA7x.png"
    }
  ]
}

        """

        val menuData = JsonParser.parseMenuData(jsonString)

        categoriesListView.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = categories[position]
            val items = when (selectedCategory) {
                "Pizza" -> menuData.pizza
                "Dessert" -> menuData.dessert
                else -> emptyList()
            }

            val menuAdapter = MenuItemsAdapter(this, items)
            menuItemsListView.adapter = menuAdapter
            menuItemsListView.visibility = View.VISIBLE
        }
    }
}