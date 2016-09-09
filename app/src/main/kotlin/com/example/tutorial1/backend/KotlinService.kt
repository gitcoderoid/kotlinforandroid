package com.example.tutorial1.backend

import android.content.Context
import android.widget.Toast
import java.util.*

class KotlinService(val context: Context) {

    fun generateUsers() = (1..100).map { it ->
        UserKotlin(author = "Author " + it,
                comments = "Comments " + it,
                vote = it + it.getRandom(),
                thumbnail = "www.randomlink.com/image/" + it,
                moreAction = {
                    Toast.makeText(context, "Button " + it + " clicked", Toast.LENGTH_SHORT).show()
                })
    }

    private fun Int.getRandom() = Random().nextInt(this) + 10
}