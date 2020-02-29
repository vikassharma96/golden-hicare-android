package com.teckudos.goldenhicare.views

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.adapters.CategoryTypeAdapter
import com.teckudos.goldenhicare.adapters.ImageSlideAdapter
import com.teckudos.goldenhicare.databinding.FragmentMainBinding
import com.teckudos.goldenhicare.domain.Category
import com.teckudos.goldenhicare.domain.Item
import com.teckudos.goldenhicare.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: FragmentMainBinding
    private var handler = Handler()
    private lateinit var runnable: Runnable
    private lateinit var item: Item
    private lateinit var imageSlideAdapter: ImageSlideAdapter
    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        init()
        initListener()
        return binding.root
    }

    private fun init() {

        val categoryAdapter = CategoryTypeAdapter { category -> onItemClick(category) }
        categoryAdapter.setItem(viewModel.category)
        with(binding.recyclerView) {
            adapter = categoryAdapter
        }

        val recommendation = CategoryTypeAdapter { category -> onItemClick(category) }
        recommendation.setItem(viewModel.recommendation)
        with(binding.recommendationRecyclerView) {
            adapter = recommendation
        }
    }

    private fun initListener() {
        imageSlideAdapter = ImageSlideAdapter()
        imageSlideAdapter.setItem(viewModel.images)
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)

        with(binding.viewPager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                val viewPager = page.parent.parent as ViewPager2
                val offset = position * -(2 * offsetPx + pageMarginPx)
                if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.translationX = -offset
                    } else {
                        page.translationX = offset
                    }
                } else {
                    page.translationY = offset
                }
            }
            registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    item = viewModel.images.get(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
            adapter = imageSlideAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        runnable = Runnable {
            if (imageSlideAdapter.itemCount == count) {
                count = 0
            } else {
                count++
            }
            binding.viewPager.setCurrentItem(count, true)
            handler.postDelayed(runnable, 4000)
        }
        handler.postDelayed(runnable, 4000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    private fun onItemClick(category: Category) {
        /*findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToCategoryDetailFragment(
                category
            )
        )*/
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToCategoryFragment())
    }
}



