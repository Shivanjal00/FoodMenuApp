package com.example.foodmenuapp

data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val spicy: Boolean,
    val vegetarian: Boolean,
    val price: String,  // Change Float to String
    val image: String
)


data class MenuData(
    val pizza: List<MenuItem>,
    val dessert: List<MenuItem>
)