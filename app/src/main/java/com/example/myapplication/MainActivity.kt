package com.example.myapplication


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.view.fragments.ConclusionFragment
import com.example.myapplication.view.fragments.CreateFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.*
import javax.net.ssl.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var bottomNavigationView = findViewById<View>(R.id.bottom_navigation_bar) as BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.action_conclusion -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,
                        ConclusionFragment()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_create -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,
                        CreateFragment()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_nearby -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,
                        ConclusionFragment()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }




}