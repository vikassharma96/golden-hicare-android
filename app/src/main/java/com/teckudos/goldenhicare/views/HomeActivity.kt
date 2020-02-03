package com.teckudos.goldenhicare.views

import android.os.Bundle
import android.view.View
import android.view.ViewParent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.ActivityHomeBinding
import com.teckudos.goldenhicare.utils.call
import com.teckudos.goldenhicare.utils.share
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityHomeBinding

    var currentController: NavController? = null

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

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navView, navController)

        binding.bottomNavigation.setupWithNavController(navController)

        setSupportActionBar(binding.mainToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        supportActionBar?.hide()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        initListeners()
    }

    private fun initListeners() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.mainFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
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

    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}
