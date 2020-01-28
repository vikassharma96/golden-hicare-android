package com.teckudos.goldenhicare.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.teckudos.goldenhicare.adapters.Category
import com.teckudos.goldenhicare.adapters.ImageSlideAdapter
import com.teckudos.goldenhicare.databinding.MainFragmentBinding
import com.teckudos.goldenhicare.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        init()
        return binding.root
    }

    private fun init(){
        val adapter = ImageSlideAdapter()
        binding.viewPager.adapter = ImageSlideAdapter()
        adapter.setItem(categories)
    }
}

val categories = listOf(
    Category(1, "Your Recording"),
    Category(2, "Film"),
    Category(3, "Series"),
    Category(4, "Kids"),
    Category(5, "Sport")
)



