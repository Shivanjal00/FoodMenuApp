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
      "description": "",
      "ingredients": ["tomato sauce", "mozzarella"],
      "spicy": false,
      "vegetarian": true,
      "price": "17.0",
      "image": "https://i.imgur.com/8B8YLOo.jpg"
    },
    {
      "id": 1,
      "name": "Pepperoni",
      "description": "",
      "ingredients": ["tomato sauce", "mozzarella", "double pepperoni"],
      "spicy": false,
      "vegetarian": false,
      "price": "20.0",
      "image": "https://i.imgur.com/OHHctnf.jpg"
    },
    {
      "id": 2,
      "name": "Rome",
      "description": "",
      "ingredients": ["tomato sauce", "mozzarella", "ham", "mushrooms", "beef cubes"],
      "spicy": false,
      "vegetarian": false,
      "price": "25.75",
      "image": "https://i.imgur.com/3ZTwCfz.png"
    }
  ],
  "dessert": [
    {
      "id": 0,
 "name": "Brownie",
 "description": "A delicious cake with chocolate and hazelnuts",
 "ingredients": [],
 "spicy": false,
 "vegetarian": false,
 "price": 15,
 "image": "https://i.imgur.com/7WbfaDN.png"
    },
    {
      "id": 1,
 "name": "Chocolate Tortilla",
 "description": "Tortilla filled with chocolate cream",
  "ingredients": [],
 "spicy": false,
 "vegetarian": false,
 "price": 12,
 "image": "https://i.imgur.com/Mgsc3IZ.png"
 
    },
    {
      "id": 2,
     "name": "Apple Pie",
     "description": "Hot pie with apple and cinnamon",
     "ingredients": [],
     "spicy": false,
     "vegetarian": true,
     "price": 15,
     "image": "https://i.imgur.com/OWIVhWX.png"
    },
    {
        "id": 3,
     "name": "Cheesecake",
     "description": "Cheesecake with berries topping",
     "ingredients": [],
     "spicy": false,
     "vegetarian": false,
     "price": 15,
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