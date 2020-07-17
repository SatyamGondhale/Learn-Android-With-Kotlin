package com.learn.learnandroidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_drawer.*

class NavDrawer : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_drawer)
        setSupportActionBar(app_toolbar)
        toolbar=findViewById(R.id.app_toolbar)
        drawerLayout=findViewById(R.id.app_drawer)
        navView=findViewById(R.id.nav_view)
        val toggle=ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile->{
                Toast.makeText(this,"Profile Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.updates->{
                Toast.makeText(this,"Updates Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.notifications->{
                Toast.makeText(this,"Notifications Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.Friends->{
                Toast.makeText(this,"Friends Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.messages->{
                Toast.makeText(this,"Messages Clicked",Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
}