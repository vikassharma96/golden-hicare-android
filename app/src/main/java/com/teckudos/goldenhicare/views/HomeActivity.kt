package com.teckudos.goldenhicare.views

import android.os.Bundle
import android.view.ViewParent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.ActivityHomeBinding
import com.teckudos.goldenhicare.utils.call
import com.teckudos.goldenhicare.utils.share


class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        drawerLayout = binding.drawerLayout
        navController = this.findNavController(R.id.myNavHostFragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment
            ), drawerLayout
        )

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navView, navController)

        supportActionBar?.hide()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        initListeners()
    }

    private fun initListeners() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            val isHandled = NavigationUI.onNavDestinationSelected(menuItem, navController)
            if (isHandled) {
                val parent: ViewParent = binding.navView.parent
                if (parent is DrawerLayout) {
                    parent.closeDrawer(binding.navView)
                }
            } else {
                when (menuItem.itemId) {
                    R.id.callus -> {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        call(this, binding.root, "9582296350")
                    }
                    R.id.invite -> {
                        share(this)
                    }
                }
            }
            isHandled
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    fun changeGraph() {
        navController.setGraph(R.navigation.navigation_main)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        supportActionBar?.show()
    }
}
