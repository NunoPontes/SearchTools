package com.frotcom.searchtools.EditTextExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.frotcom.searchtools.R
import com.frotcom.searchtools.SearchAdapter
import com.frotcom.searchtools.SearchModel
import java.util.ArrayList

class EditTextActivity : AppCompatActivity() {

    @BindView(R.id.recycler)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.editText)
    lateinit var etsearch: EditText

    private var adapter: SearchAdapter? = null
    private var moviewList: Array<String>? = null
    internal var textlength = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)
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
            "Shreck",
            "Joker"
        )
        movieNamesArrayLists = populateList()

        adapter = SearchAdapter(this, movieNamesArrayLists)
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        array_sort = ArrayList()
        array_sort = populateList()


        etsearch!!.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                textlength = etsearch!!.text.length
                array_sort.clear()
                for (i in movieNamesArrayLists.indices) {
                    if (textlength <= movieNamesArrayLists[i].getNames().length) {
                        Log.d("ertyyy", movieNamesArrayLists[i].getNames().toLowerCase().trim())
                        if (movieNamesArrayLists[i].getNames().toLowerCase().trim().contains(
                                etsearch!!.text.toString().toLowerCase().trim { it <= ' ' })
                        ) {
                            array_sort.add(movieNamesArrayLists[i])
                        }
                    }
                }
                adapter = SearchAdapter(this@EditTextActivity, array_sort)
                recyclerView!!.adapter = adapter
                recyclerView!!.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            }
        })


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
        lateinit var movieNamesArrayLists: ArrayList<SearchModel>
        lateinit var array_sort: ArrayList<SearchModel>
    }
}
