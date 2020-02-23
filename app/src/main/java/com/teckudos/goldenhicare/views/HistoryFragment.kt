package com.teckudos.goldenhicare.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teckudos.goldenhicare.adapters.HistoryAdapter
import com.teckudos.goldenhicare.databinding.FragmentHistoryBinding
import com.teckudos.goldenhicare.domain.HistoryItem
import kotlin.random.Random

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater)
        init()
        return binding.root
    }

    private fun init() {
        val historyAdapter = HistoryAdapter()
        val list = arrayListOf<HistoryItem>()
        for (i in 1..5) {
            val item = HistoryItem(
                i,
                Random.nextInt().toString(),
                "Name ${i}",
                "Company Name ${i}",
                "2${i} Feb 19",
                "Delivered",
                "Package ${i}",
                "Rs 425${i}",
                "958229635${i}",
                "Your order delivered on 2${i + 4} Feb 19"
            )
            list.add(item)
        }
        historyAdapter.setItem(list = list)
        binding.recyclerView.adapter = historyAdapter
    }

}
