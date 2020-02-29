package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.teckudos.goldenhicare.databinding.FragmentCategoryDetailBinding
import com.teckudos.goldenhicare.viewmodels.CategoryDetailViewModel

class CategoryDetailFragment : Fragment() {

    private val viewModel: CategoryDetailViewModel by lazy {
        ViewModelProvider(this).get(CategoryDetailViewModel::class.java)
    }
    private lateinit var args: CategoryDetailFragmentArgs
    private lateinit var binding: FragmentCategoryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryDetailBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        init()
        return binding.root
    }

    private fun init() {
        args = CategoryDetailFragmentArgs.fromBundle(arguments!!)
        val category = args.category

    }
}
