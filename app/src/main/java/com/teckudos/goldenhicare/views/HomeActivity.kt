package com.teckudos.goldenhicare.views

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.databinding.ActivityHomeBinding
import timber.log.Timber


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
        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.callus -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    callFromDialer("9582296350")
                }
                R.id.invite -> {
                    share()
                }
                else -> {
                    Timber.i("called")
                }
            }
            true
        })
        supportActionBar?.hide()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    fun changeGraph() {
        supportActionBar?.show()
        navController.setGraph(R.navigation.navigation_main)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    private fun callFromDialer(number: String) {
        try {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:$number")
            startActivity(callIntent)
        } catch (e: Exception) {
            Timber.i(e)
            Snackbar.make(
                binding.root,
                "No sim found",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun share() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText("Golden Hicare")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
