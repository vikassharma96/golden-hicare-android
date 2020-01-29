package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.teckudos.goldenhicare.databinding.FragmentLoginBinding
import com.teckudos.goldenhicare.viewmodels.LoginViewModel
import timber.log.Timber

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        init()
        initObserver()
        return binding.root
    }

    private fun init() {}

    private fun initObserver() {
        viewModel.navigateToMain.observe(viewLifecycleOwner,
            Observer<Boolean> { shouldNavigate ->
                Timber.i("called")
                if (shouldNavigate == true) {
                    (requireActivity() as HomeActivity).changeGraph()
                }
            })
    }
}
