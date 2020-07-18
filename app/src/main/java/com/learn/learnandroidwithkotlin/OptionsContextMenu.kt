package com.learn.learnandroidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.options_context_menu.*

class OptionsContextMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.options_context_menu)
        registerForContextMenu(android_development)
    }

    // Show Context Menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    // Show Options Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.options_menu,menu
        )
        return true
    }

    // Options Menu Item Selected Listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.rate_app->{
                Toast.makeText(this,"Rating not enabled.",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.send_feedback->{
                Toast.makeText(this,"Feedback not enabled",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Context Menu Item Selected Listener
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_one->{
                Toast.makeText(this,"Menu One Selected.",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_two->{
                Toast.makeText(this,"Menu Two Selected.",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_three->{
                Toast.makeText(this,"Menu Three Selected.",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_four->{
                Toast.makeText(this,"Menu Four Selected.",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}