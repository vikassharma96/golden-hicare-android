package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.teckudos.goldenhicare.adapters.CategoryAdapter
import com.teckudos.goldenhicare.databinding.FragmentSearchBinding
import com.teckudos.goldenhicare.domain.CategoryItem

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: CategoryAdapter

    companion object {
        lateinit var categoryList: ArrayList<CategoryItem>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        init()
        initListener()
        return binding.root
    }

    private fun init() {
        adapter = CategoryAdapter { onItemClick() }
        categoryList = getCategoryItem()
        adapter.setItem(categoryList)
        binding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                val searchList = arrayListOf<CategoryItem>()
                for (item in categoryList) {
                    if (item.name.contains(query, true) || item.number.contains(
                            query,
                            true
                        )
                    ) {
                        searchList.add(item)
                    }
                }
                adapter.setItem(searchList)
                return false
            }
        })
    }

    private fun onItemClick() {
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCategoryDetailFragment())
    }

    private fun getCategoryItem(): ArrayList<CategoryItem> {
        val categoryItem = arrayListOf<CategoryItem>()
//        for (count in 0..10) {
        categoryItem.add(
            CategoryItem(
                1,
                "",
                "Vikas Sharma",
                "Teckudos Pvt Ltd",
                "4",
                "95%",
                "9582296350",
                "teckudos@gmail.com"
            )
        )
        categoryItem.add(
            CategoryItem(
                2,
                "",
                "ABC DEF",
                "SAFASF Pvt Ltd",
                "2",
                "25%",
                "1231241241",
                "abc@gmail.com"
            )
        )
        categoryItem.add(
            CategoryItem(
                3,
                "",
                "DDGSDG Sharma",
                "RPJGRG Pvt Ltd",
                "5",
                "45%",
                "9829823489",
                "support@gmail.com"
            )
        )
        categoryItem.add(
            CategoryItem(
                4,
                "",
                "QWEWR MKNIN",
                "GKSLKG Pvt Ltd",
                "1",
                "75%",
                "9893453454",
                "help@gmail.com"
            )
        )
//        }
        return categoryItem
    }

}
