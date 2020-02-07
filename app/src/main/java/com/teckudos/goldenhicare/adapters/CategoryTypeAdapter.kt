package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.RowCategoryTypeBinding
import com.teckudos.goldenhicare.domain.Category

class CategoryTypeAdapter(private val onItemCLick: () -> Unit) : RecyclerView.Adapter<CategoryTypeViewHolder>() {

    private var items: List<Category> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryTypeViewHolder {
        val withDataBinding: RowCategoryTypeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CategoryTypeViewHolder.LAYOUT,
            parent,
            false
        )
        return CategoryTypeViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CategoryTypeViewHolder, position: Int) {
        holder.categoryBinding.also {
            it.item = items[position]
            it.clMain.setOnClickListener {
                onItemCLick.invoke()
            }
        }
    }

    fun setItem(list: List<Category>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}

class CategoryTypeViewHolder(val categoryBinding: RowCategoryTypeBinding) :
    RecyclerView.ViewHolder(categoryBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_category_type
    }
}

