package com.example.myandroidseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    var names = arrayListOf("Henri", "Gabriel", "Paul", "Camille",
                                        "Marc", "Laurent", "Jervezine", "Gabrielle")

    lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names)
        listView.adapter = arrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        var menuItem: MenuItem = menu.findItem(R.id.action_search)
        var searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Search View Hint"

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                arrayAdapter.filter.filter(newText)
                return false
            }
        } )

        return super.onCreateOptionsMenu(menu)
    }
}
