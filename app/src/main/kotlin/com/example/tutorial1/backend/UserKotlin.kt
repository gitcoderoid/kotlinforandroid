package com.example.tutorial1.backend

data class UserKotlin(val author: String,
                      val comments: String,
                      val vote: Int,
                      val thumbnail: String,
                      val moreAction: () -> Unit)