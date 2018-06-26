package com.example.zzw.expand

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zzw.expand.adapter.ChildViewBinder
import com.example.zzw.expand.adapter.ParentViewBinder
import com.example.zzw.expand.model.ChildModel
import com.example.zzw.expand.model.ParentModel
import com.example.zzw.expand.model.TreeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import me.drakeet.multitype.MultiTypeAdapter

/**
 * !!该项目整理自github上nuptboyzhb的TreeRecyclerView项目：https://github.com/nuptboyzhb/TreeRecyclerView
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 用了就停不下来的adapter，强烈推荐，尤其适用于复杂的列表视图
         * github地址：https://github.com/drakeet/MultiType
         */
        val adapter = MultiTypeAdapter()
        adapter.register(ParentModel::class.java, ParentViewBinder())
        adapter.register(ChildModel::class.java, ChildViewBinder())
        adapter.items = generateItems()
        recyclerView.adapter = adapter
    }

    private fun generateItems(): ArrayList<Any> {
        val items = ArrayList<Any>()
        val beiChild = arrayListOf<TreeViewModel>(ChildModel("刘封"), ChildModel("刘禅"), ChildModel("刘永"), ChildModel("刘理"))
        val liangChild = arrayListOf<TreeViewModel>(ChildModel("诸葛乔"), ChildModel("诸葛瞻"), ChildModel("诸葛怀"), ChildModel("诸葛果"))
        val yuChild = arrayListOf<TreeViewModel>(ChildModel("关平"), ChildModel("关兴"))
        val feiChild = arrayListOf<TreeViewModel>(ChildModel("张苞"), ChildModel("张绍"))
        val yunChild = arrayListOf<TreeViewModel>(ChildModel("赵统"), ChildModel("赵广"))
        val bei = ParentModel("刘备")
        bei.children = beiChild
        val liang = ParentModel("诸葛亮")
        liang.children = liangChild
        val yu = ParentModel("关羽")
        yu.children = yuChild
        val fei = ParentModel("张飞")
        fei.children = feiChild
        val yun = ParentModel("赵云")
        yun.children = yunChild
        items.add(bei)
        items.add(liang)
        items.add(yu)
        items.add(fei)
        items.add(yun)
        return items
    }
}
