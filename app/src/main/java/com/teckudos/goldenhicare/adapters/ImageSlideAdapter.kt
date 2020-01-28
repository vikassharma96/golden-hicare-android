package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import kotlinx.android.synthetic.main.category_item.view.*

class ImageSlideAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    var list: List<Category> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent)
    }
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }
    fun setItem(list: List<Category>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size
}

class CategoryViewHolder constructor(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    constructor(parent: ViewGroup) :
            this(LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false))

    fun bind(category: Category) {
        itemView.categoryName.text = category.name
    }
}

class Category(var id: Int, var name: String) {

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null || javaClass != obj.javaClass) return false
        val category = obj as Category
        if (id != category.id) return false
        return name == category.name

    }

    override fun hashCode(): Int {
        var result = id
        result += name.hashCode()
        return result
    }
}