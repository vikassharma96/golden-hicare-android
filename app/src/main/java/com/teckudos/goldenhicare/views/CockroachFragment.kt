package com.teckudos.goldenhicare.views


import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.teckudos.goldenhicare.databinding.FragmentCockroachBinding
import com.teckudos.goldenhicare.domain.Category


class CockroachFragment : Fragment() {

    private lateinit var binding: FragmentCockroachBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCockroachBinding.inflate(inflater)
        init()
        return binding.root
    }

    private fun init() {
        binding.originalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        binding.viewDetails.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment(
                    Category(1, "", 1)
                )
            )
        }
    }

}
