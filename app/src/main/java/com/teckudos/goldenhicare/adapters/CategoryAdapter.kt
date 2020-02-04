package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.RowCategoryTypeBinding
import com.teckudos.goldenhicare.domain.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private var items: List<Category> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val withDataBinding: RowCategoryTypeBinding = DataBindingUtil.inflate(
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
        }
    }

    fun setItem(list: List<Category>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}

class CategoryViewHolder(val categoryBinding: RowCategoryTypeBinding) :
    RecyclerView.ViewHolder(categoryBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_category_type
    }
}

