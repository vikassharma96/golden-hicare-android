package com.teckudos.goldenhicare.domain

data class Item(var id: Int, var url: String)

data class Category(var id: Int, var name: String, var image: Int)

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

data class HistoryItem(
    var id: Int,
    var transactionId: String,
    var name: String,
    var company: String,
    var date: String,
    var status: String,
    var packageType: String,
    var price: String,
    var number: String,
    var text: String
)