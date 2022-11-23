package com.example.bottomnavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationfragment.fragment.HomeFragment
import com.example.bottomnavigationfragment.fragment.NotificationFragment
import com.example.bottomnavigationfragment.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingFragment()

        makeCurrentFragmet (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragmet(homeFragment)
                R.id.menu_notification -> makeCurrentFragmet(notificationFragment)
                R.id.menu_settings -> makeCurrentFragmet(settingsFragment)
            }
            true
        }

    }

    private fun makeCurrentFragmet(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}