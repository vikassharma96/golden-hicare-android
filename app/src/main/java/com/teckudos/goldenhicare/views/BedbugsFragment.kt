package com.teckudos.goldenhicare.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.FragmentBedbugsBinding
import com.teckudos.goldenhicare.databinding.FragmentCategoryBinding

class BedbugsFragment : Fragment() {

    private lateinit var binding: FragmentBedbugsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBedbugsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

}
