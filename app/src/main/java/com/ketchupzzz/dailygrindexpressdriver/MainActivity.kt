package com.ketchupzzz.dailygrindexpressdriver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ketchupzzz.dailygrindexpressdriver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController : NavController = findNavController(R.id.container)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.menu_take_order,R.id.menu_history,R.id.menu_wallet,R.id.menu_profile))
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{ _: NavController? ,destination : NavDestination, _ : Bundle ? ->
            when (destination.id) {
                R.id.menu_take_order -> {
                    showBottomNav()
                }
                R.id.menu_history -> {
                    showBottomNav()
                }
                R.id.menu_wallet -> {
                    showBottomNav()
                }
                R.id.menu_profile -> {
                    showBottomNav()
                }
                else -> {
                    hideBottomNav()
                }
            }
        }
        binding.switchButton.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                binding.availableContainer.visibility = View.VISIBLE
            } else {
                binding.availableContainer.visibility = View.GONE
            }
        }
    }
    private fun showBottomNav() {
        binding.bottomAppBar.performShow(true)
        binding.bottomAppBar.hideOnScroll = true
    }
    private fun hideBottomNav() {
        binding.bottomAppBar.performHide(true)
        binding.bottomAppBar.hideOnScroll = false

    }
}