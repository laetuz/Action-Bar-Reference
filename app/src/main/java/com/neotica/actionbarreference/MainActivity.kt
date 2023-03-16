package com.neotica.actionbarreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.neotica.actionbarreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Step 10: Override onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Step 11: Create a new variable that inflates menu 'menuInflater'
        val inflater = menuInflater
        //Step 12: Inflate option menu from menu resource
        inflater.inflate(R.menu.option_menu, menu)
        //Step 13: return to boolean true
        return true
    }

    //Step 14: Override onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Step 15: Create condition when which menu items is selected
        when (item.itemId){
            //Step 16: Define which item will be selected
            R.id.menu1 -> {
                //Step 17: Define the item onclick action
                //Step 17.1: Add the navigation transaction
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
            }
            R.id.menu2 -> {
                //Step 17: Define the item onclick action
                //Step 17.2: Add activity intent
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
        return true
    }
}