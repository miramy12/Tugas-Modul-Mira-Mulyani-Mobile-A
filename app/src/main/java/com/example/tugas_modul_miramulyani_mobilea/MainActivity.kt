package com.example.tugas_modul_miramulyani_mobilea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tugas_modul_miramulyani_mobilea.fragment.NotificationFragment
import com.example.tugas_modul_miramulyani_mobilea.fragment.PesananFragment
import com.example.tugas_modul_miramulyani_mobilea.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.navbar)

        val fragment = NotificationFragment.newInstance("test1", "test2")
        bottom_navigation.setOnNavigationItemSelectedListener (menuItemSelected)
    }

    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigation_home->{
                val fragment = NotificationFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pesanan->{
                val fragment = PesananFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile->{
                val fragment = ProfileFragment.newInstance("test1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(com.google.android.material.R.anim.design_bottom_sheet_slide_in, com.google.android.material.R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}