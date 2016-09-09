package com.example.tutorial1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutorial1.backend.UserKotlin
import kotlinx.android.synthetic.main.recycler_view_adapter.view.*

class KotlinRecyclerView(val application: Context) : RecyclerView.Adapter<KotlinRecyclerView.ViewHolder>() {

    var list = listOf<UserKotlin>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val user = list[i]
        viewHolder.author.text = user.author
        viewHolder.vote.text = user.vote.toString()
        viewHolder.comments.text = user.comments
        viewHolder.thumbnail.text = user.thumbnail
        viewHolder.more.setOnClickListener { user.moreAction.invoke() }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.recycler_view_adapter, viewGroup, false)
        return ViewHolder(itemView)
    }

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val author = view.author
        val comments = view.comments
        val vote = view.vote
        val thumbnail = view.thumbnail
        val more = view.more
    }

}
