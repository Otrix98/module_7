package com.example.module_7

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.activity_scrolling.toolbar
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    private val users = listOf(
        "User1",
        "User2",
        "UnknownUser"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setContentView(R.layout.activity_scrolling)
        toolbar.setNavigationOnClickListener {
            toast("Navigation clicked")
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when( menuItem.itemId) {
                R.id.action_1 -> {
                    toast("action 1")
                    true
                }
                R.id.action_2 -> {
                    toast("action 2")
                    true
                }
                else -> false
            }

        }

        val searchItem = toolbar.menu.findItem(R.id.action_search)
        searchItem.setOnActionExpandListener(object: MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
            return true}

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                return true
            }
        })
        (searchItem.actionView as SearchView).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                users.filter { it.contains(other = newText ?: "", ignoreCase = true) }
                    .joinToString()
                    .let{
                        searchResult.text = it
                    }
                    return true
                }
            }
        )
    }
        fun toast(text: String) {
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }
}


