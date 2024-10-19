package com.example.foodmenuapp

data class MenuData(
    val pizza: List<MenuItem>,
    val dessert: List<MenuItem>
)

data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val spicy: Boolean,
    val vegetarian: Boolean,
    val price: String,
    val image: String
)
