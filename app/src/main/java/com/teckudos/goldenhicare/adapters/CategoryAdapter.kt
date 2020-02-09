package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.RowCategoryItemBinding
import com.teckudos.goldenhicare.domain.CategoryItem

class CategoryAdapter(private val onItemCLick: () -> Unit) : RecyclerView.Adapter<CategoryViewHolder>() {

    private var items: List<CategoryItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val withDataBinding: RowCategoryItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CategoryViewHolder.LAYOUT,
            parent,
            false
        )
        return CategoryViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryBinding.also {
            it.item = items[position]
            it.clMain.setOnClickListener {
                onItemCLick.invoke()
            }
        }
    }

    fun setItem(list: List<CategoryItem>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}

class CategoryViewHolder(val categoryBinding: RowCategoryItemBinding) :
    RecyclerView.ViewHolder(categoryBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_category_item
    }
}