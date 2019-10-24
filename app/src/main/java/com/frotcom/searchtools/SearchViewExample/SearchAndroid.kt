package com.frotcom.searchtools.SearchViewExample

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.frotcom.searchtools.R
import com.frotcom.searchtools.SearchAdapter
import com.frotcom.searchtools.SearchModel


class SearchAndroid : AppCompatActivity(), SearchView.OnQueryTextListener {

    @BindView(R.id.main_recycler)
    lateinit var mRecyclerView: RecyclerView

    private var adapter: SearchAdapter? = null
    private var moviewList: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_android)
        ButterKnife.bind(this)
        moviewList = arrayOf(
            "Xmen",
            "Titanic",
            "Captain America",
            "Iron man",
            "Rocky",
            "Transporter",
            "Lord of the rings",
            "The jungle book",
            "Tarzan",
            "Cars",
            "Shrek",
            "Joker"
        )
        movieNamesArrayList = populateList()
        adapter = SearchAdapter(
            this,
            movieNamesArrayList
        )
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        val item = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(item) as SearchView

        searchView.setOnQueryTextListener(this)

        return true
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            adapter!!.filter(newText)
        }
        return false
    }

    private fun populateList(): ArrayList<SearchModel> {

        val list = ArrayList<SearchModel>()

        for (i in 0 until moviewList!!.size) {
            val imageModel = SearchModel()
            imageModel.setNames(moviewList!![i])
            list.add(imageModel)
        }

        return list
    }

    companion object {
        lateinit var movieNamesArrayList: ArrayList<SearchModel>
        lateinit var array_sort: ArrayList<SearchModel>
    }
}
