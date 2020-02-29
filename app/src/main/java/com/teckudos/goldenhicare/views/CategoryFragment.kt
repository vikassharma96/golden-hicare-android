package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.adapters.FragmentViewPagerAdapter
import com.teckudos.goldenhicare.databinding.CustomTabBinding
import com.teckudos.goldenhicare.databinding.FragmentCategoryBinding
import com.teckudos.goldenhicare.viewmodels.CategoryViewModel


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by lazy {
        ViewModelProvider(this).get(CategoryViewModel::class.java)
    }

    companion object {
        val list = arrayListOf("Cockroach & ant", " Termite", "Bedbugs", "Mosquitoes")
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = FragmentViewPagerAdapter(childFragmentManager, lifecycle)
        pagerAdapter.populateFragment(CockroachFragment(), "Cockroach Fragment")
        pagerAdapter.populateFragment(TermitesFragment(), "Termites Fragment")
        pagerAdapter.populateFragment(BedbugsFragment(), "Bedbugs Fragment")
        pagerAdapter.populateFragment(MosquitoesFragment(), "Mosquitoes Fragment")

        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = list[position]
//                tab.customView = getView(position)
            }).attach()
    }

    private fun getView(position: Int): View {
        val inflater = LayoutInflater.from(requireContext())
        val binding = CustomTabBinding.inflate(inflater)
        binding.name.text = list[position]
        binding.name.setOnClickListener {

        }
        return binding.root
    }

    private fun init() {
        /*with(binding) {
            val adapter = CategoryAdapter { onItemClick() }
            adapter.setItem(viewModel.getCategoryItem())
            rvCategory.adapter = adapter
        }*/
    }

    private fun onItemClick() {
        // findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment())
    }
}
