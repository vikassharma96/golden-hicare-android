package com.teckudos.goldenhicare.domain

data class Item(var id: Int, var url: String)

data class Category(var id: Int, var name: String)

data class CategoryItem(
    var id: Int,
    var image: String,
    var name: String,
    var description: String,
    var rating: String,
    var percent: String,
    var number: String,
    var email: String
)