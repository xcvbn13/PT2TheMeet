package org.d3if4094.fjbtelyu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navbar: BottomNavigationView = findViewById(R.id.bottom_nav_app)

//        bottom
        val fragment = HomeFragment.newInstance("test1","test2")
        navbar.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)
    }
    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.home -> {
                // Respond to navigation item 1 click
                val fragment = HomeFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.search -> {
                // Respond to navigation item 2 click
                val fragment = SearchFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.notif -> {
                // Respond to navigation item 1 click
                val fragment = NotifFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.person -> {
                // Respond to navigation item 2 click
                val fragment = PersonFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> false
        }
    }

    @SuppressLint("PrivateResource")
    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(com.google.android.material.R.anim.design_bottom_sheet_slide_in,
                com.google.android.material.R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.fragment_container,fragment,fragment.javaClass.getSimpleName())
            .commit()
    }


}