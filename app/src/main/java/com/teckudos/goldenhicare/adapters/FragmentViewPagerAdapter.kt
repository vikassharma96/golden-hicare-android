package com.teckudos.goldenhicare.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifeCycle) {

    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun populateFragment(fragment: Fragment,title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    fun getPageTitle(position: Int) = titleList[position]
}