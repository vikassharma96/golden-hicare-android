package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.FragmentSplashBinding
import com.teckudos.goldenhicare.utils.SharedPreferenceUtil


class SplashFragment : Fragment() {

    private var handler = Handler()
    private lateinit var runnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashBinding.inflate(inflater)
        init()
        return binding.root
    }

    private fun init() {
        runnable = Runnable {
            if (SharedPreferenceUtil.isRegistered) {
                (requireActivity() as HomeActivity).changeGraph()
            } else{
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        }
        handler.postDelayed(runnable, 1000)
    }

}
