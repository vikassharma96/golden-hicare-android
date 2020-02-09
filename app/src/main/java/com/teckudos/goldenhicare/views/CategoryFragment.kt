package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.teckudos.goldenhicare.adapters.CategoryAdapter
import com.teckudos.goldenhicare.databinding.FragmentCategoryBinding
import com.teckudos.goldenhicare.domain.CategoryItem
import com.teckudos.goldenhicare.viewmodels.CategoryViewModel
import timber.log.Timber

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by lazy {
        ViewModelProvider(this).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        init()
        return binding.root
    }

    private fun init() {
        with(binding) {
            val adapter = CategoryAdapter { onItemClick() }
            adapter.setItem(viewModel.getCategoryItem())
            rvCategory.adapter = adapter
        }
    }

    private fun onItemClick() {
        findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment())
    }
}
