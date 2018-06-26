package com.example.zzw.expand.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zzw.expand.R
import com.example.zzw.expand.model.ChildModel
import kotlinx.android.synthetic.main.item_child.view.*

import me.drakeet.multitype.ItemViewBinder

/**
 * Created by zzw on 2018/6/22.
 */
class ChildViewBinder : ItemViewBinder<ChildModel, ChildViewBinder.ViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val root = inflater.inflate(R.layout.item_child, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, child: ChildModel) {
        holder.itemView.tvContent.text = child.content
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
