package com.example.tutorial1

import android.content.Context
import com.example.tutorial1.MainActivityKotlinPresenter.FilterType.*
import com.example.tutorial1.backend.KotlinService
import com.example.tutorial1.backend.UserKotlin

class MainActivityKotlinPresenter(val view: MainActivityKotlinView, val context: Context) {

    private val kotlinService = KotlinService(context)

    fun downloadData() {
        val generateUsers = kotlinService.generateUsers()
        view.showList(generateUsers)
    }

    fun refreshData(filterType: FilterType) {
        val generateUsers = kotlinService.generateUsers()
        val filteredList = when (filterType) {
            MORE_THAN_25 -> generateUsers.filterBy { it.vote > 25 }
            MORE_THAN_50 -> generateUsers.filterBy { it.vote > 50 }
            MORE_THAN_100 -> generateUsers.filterBy { it.vote > 100 }
        }.sortedByDescending { it.vote }
        view.refreshList(filteredList)
        view.terminateLoading()
    }

    private fun List<UserKotlin>.filterBy(predicate: (UserKotlin) -> Boolean) = this.filter(predicate)

    enum class FilterType {
        MORE_THAN_25, MORE_THAN_50, MORE_THAN_100
    }
}

