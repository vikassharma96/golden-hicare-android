package com.teckudos.goldenhicare.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.FragmentDashBoardBinding

class DashBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDashBoardBinding.inflate(inflater)
        return binding.root
    }

}
