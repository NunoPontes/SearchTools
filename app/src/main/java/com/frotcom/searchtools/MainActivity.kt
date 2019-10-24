package com.frotcom.searchtools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.frotcom.searchtools.EditTextExample.EditTextActivity
import com.frotcom.searchtools.SearchViewExample.SearchAndroid


class MainActivity : AppCompatActivity() {

    @BindView(R.id.btnSearchView)
    lateinit var mButtonSearchView: Button

    @BindView(R.id.btnEditText)
    lateinit var mButtonEditText: Button

    @BindView(R.id.btnSearchViewList)
    lateinit var mButtonSearchViewList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btnSearchView)
    fun searchView() {
        val myIntent = Intent(this, SearchAndroid::class.java)
        this.startActivity(myIntent)
    }

    @OnClick(R.id.btnEditText)
    fun editText() {
        val myIntent = Intent(this, EditTextActivity::class.java)
        this.startActivity(myIntent)
    }

//    @OnClick(R.id.btnSearchViewList)
//    fun searchViewList() {
//        val myIntent = Intent(this, ::class.java)
//        this.startActivity(myIntent)
//    }
}
