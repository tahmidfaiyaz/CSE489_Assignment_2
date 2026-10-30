package com.example.cse489assignment2

import android.os.Bundle

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: MaterialToolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)


        // Make toolbar behave like the ActionBar
        setSupportActionBar(toolbar)

        // Create hamburger button
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Drawer menu clicks
        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_broadcast -> {

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            BroadcastFragment()
                        )
                        .commit()
                }

                R.id.nav_image -> {

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            ImageScaleFragment()
                        )
                        .commit()
                }

                R.id.nav_video -> {

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            VideoFragment()
                        )
                        .commit()
                }

                R.id.nav_audio -> {

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            AudioFragment()
                        )
                        .commit()
                }
            }

            drawerLayout.closeDrawers()

            true
        }
    }
}