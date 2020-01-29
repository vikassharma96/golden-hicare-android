package com.teckudos.goldenhicare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.RowItemImageBinding
import com.teckudos.goldenhicare.domain.Item

class ImageSlideAdapter : RecyclerView.Adapter<ImageViewHolder>() {

    var items: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val withDataBinding: RowItemImageBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ImageViewHolder.LAYOUT,
            parent,
            false
        )
        return ImageViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.rowItemImageBinding.also {
            it.item = items[position]
        }
    }

    fun setItem(list: List<Item>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}

class ImageViewHolder(val rowItemImageBinding: RowItemImageBinding) :
    RecyclerView.ViewHolder(rowItemImageBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_item_image
    }
}

