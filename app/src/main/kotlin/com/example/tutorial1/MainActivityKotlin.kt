package com.example.tutorial1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.tutorial1.MainActivityKotlinPresenter.FilterType
import com.example.tutorial1.backend.UserKotlin
import kotlinx.android.synthetic.main.activity_main_activity_kotlin.*

class MainActivityKotlin : AppCompatActivity(), MainActivityKotlinView {

    private lateinit var kotlinPresenter: MainActivityKotlinPresenter
    private lateinit var kotlinAdapter: KotlinRecyclerView

    private var swipeCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_kotlin)
        val llm = LinearLayoutManager(this);
        llm.orientation = LinearLayoutManager.VERTICAL
        main_activity_kotlin_list.layoutManager = llm
        kotlinAdapter = KotlinRecyclerView(applicationContext)
        main_activity_kotlin_list.adapter = kotlinAdapter
        kotlinPresenter = MainActivityKotlinPresenter(view = this, context = applicationContext)
        kotlinPresenter.downloadData()
        swipe_container_kotlin.setOnRefreshListener {
            kotlinPresenter.refreshData(getFilterType())
            swipeCounter++
        }
    }

    override fun showList(list: List<UserKotlin>) {
        kotlinAdapter.list = list
    }

    override fun refreshList(list: List<UserKotlin>) {
        kotlinAdapter.list = list
    }

    override fun terminateLoading() {
        swipe_container_kotlin.isRefreshing = false
    }

    private fun getFilterType() = when (swipeCounter) {
        0 -> FilterType.MORE_THAN_25
        1 -> FilterType.MORE_THAN_50
        2 -> FilterType.MORE_THAN_100
        else -> {
            swipeCounter = 0
            FilterType.MORE_THAN_25
        }
    }

}
