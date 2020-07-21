package com.example.notes.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.notes.R
import com.example.notes.note.BaseActivity
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),  View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this,R.id.fragment)
        setupActionBarWithNavController(this,navController)

    }

//    override fun initComponents() {
//        val navController = Navigation.findNavController(this,R.id.fragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
////        val navigationView = findViewById(R.id.nav_view) as NavigationView
////        navigationView.setNavigationItemSelectedListener(this)
//    }

//    override fun getLayoutId(): Int {
//        return R.layout.activity_main
//    }

    override fun onNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment),null
        )
    }

//    override fun onNavigationItemSelected(item: MenuItem):Boolean {
//        when (item.itemId) {
//            R.id.nav_notes -> {
//                navigateTo(R.id.nav_notes)
//            }
//            R.id.nav_settings -> {
//                navigateTo(R.id.nav_settings)
//            }
//            R.id.nav_archive -> {
//                navigateTo(R.id.nav_archive)
//            }
//            R.id.nav_deleted -> {
//                navigateTo(R.id.nav_deleted)
//            }
//            R.id.nav_reminders -> {
//                navigateTo(R.id.nav_reminders)
//            }
//            R.id.nav_help -> {
//                navigateTo(R.id.nav_help)
//            }
//            R.id.nav_label -> {
//                navigateTo(R.id.nav_label)
//            }
//        }
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

    private fun navigateTo(id:Int) {
        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(id)
    }

    override fun onClick(v: View?) {

    }
}