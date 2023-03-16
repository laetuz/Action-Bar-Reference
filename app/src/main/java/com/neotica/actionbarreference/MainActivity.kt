package com.neotica.actionbarreference

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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

        //Step 19: Create a new variable that gets SEARCH_SERVICE
        //from getSystemService as SearchManager
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        //Step 20: Create a new variable that define the search from menu resource as SearchView
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        //Step 21: Setup Searchable Info
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        //Step 22: Setup a string resource (abc_search_hint) that provides the default hint text for the searchView.
        searchView.queryHint = resources.getString(androidx.appcompat.R.string.abc_search_hint)
        //Step 23: setOnQueryTextListener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //Step 24: When search has been OK'ed
            override fun onQueryTextSubmit(query: String?): Boolean {
                //Step 25: Provides the value on OK'ed
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

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