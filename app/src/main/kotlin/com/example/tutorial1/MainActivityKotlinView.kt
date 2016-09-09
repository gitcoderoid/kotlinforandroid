package com.example.tutorial1

import com.example.tutorial1.backend.UserKotlin

interface MainActivityKotlinView {

    fun showList(list: List<UserKotlin>)

    fun refreshList(list: List<UserKotlin>)

    fun terminateLoading()
}