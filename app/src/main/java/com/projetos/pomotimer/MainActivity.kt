package com.projetos.pomotimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val todoFragment = TodoFragment()
    private val configFragment = ConfigFragment()
    private val timerFragment = TimerFragment()
    private val addFragment = AddFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        replaceFragment(todoFragment)

        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_todo -> replaceFragment(todoFragment)
                R.id.nav_config -> replaceFragment(configFragment)
                R.id.nav_timer -> replaceFragment(timerFragment)
                R.id.nav_add -> replaceFragment(addFragment)
            }
            true
        }



    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.body_container, fragment)
        transaction.commit()
    }
}

