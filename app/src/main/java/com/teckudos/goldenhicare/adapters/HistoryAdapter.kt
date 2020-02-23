package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.RowCategoryItemBinding
import com.teckudos.goldenhicare.databinding.RowHistoryItemBinding
import com.teckudos.goldenhicare.domain.CategoryItem
import com.teckudos.goldenhicare.domain.HistoryItem
import com.teckudos.goldenhicare.views.SearchFragment

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {

    private var items: ArrayList<HistoryItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val withDataBinding: RowHistoryItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            HistoryViewHolder.LAYOUT,
            parent,
            false
        )
        return HistoryViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.historyBinding.also {
            it.item = items[position]
        }
    }

    fun setItem(list: ArrayList<HistoryItem>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}

class HistoryViewHolder(val historyBinding: RowHistoryItemBinding) :
    RecyclerView.ViewHolder(historyBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_history_item
    }
}