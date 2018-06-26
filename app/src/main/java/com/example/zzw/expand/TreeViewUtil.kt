package com.example.zzw.expand

import android.animation.ObjectAnimator
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.zzw.expand.model.TreeViewModel

class TreeViewUtil {
    companion object {

        /**
         * 旋转指示图标
         */
        fun rotationExpandIcon(imgView: View, startAngle: Float, endAngle: Float) {
            val animator = ObjectAnimator.ofFloat(imgView, "rotation", startAngle, endAngle)
            animator.duration = 300
            animator.start()
        }

        /**
         * 实现展开/收起时数据的添加和移除
         * 核心代码是不是非常少
         */
        fun generateExpandAndHideListener(): OnExpandAndHideListener {
            return object : OnExpandAndHideListener {
                override fun onExpand(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, adapterItems: ArrayList<TreeViewModel>, clickedItem: TreeViewModel, clickedItemPosition: Int) {
                    val isBadData = clickedItemPosition == RecyclerView.NO_POSITION || clickedItem.children?.isNotEmpty() != true
                    if (isBadData) {
                        return
                    }
                    val childStartPosition = clickedItemPosition + 1
                    adapterItems.addAll(childStartPosition, clickedItem.children!!)
                    adapter.notifyItemRangeInserted(childStartPosition, clickedItem.children!!.size)
                }

                override fun onHide(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, adapterItems: ArrayList<TreeViewModel>, clickedItem: TreeViewModel, clickedItemPosition: Int) {
                    val isBadData = clickedItemPosition == RecyclerView.NO_POSITION || clickedItem.children?.isNotEmpty() != true
                    if (isBadData) {
                        return
                    }
                    val childStartPosition = clickedItemPosition + 1
                    val childCount = TreeViewModel.getChildCountForHide(clickedItem)
                    for (i in 0 until childCount) {
                        adapterItems.removeAt(childStartPosition)
                    }
                    adapter.notifyItemRangeRemoved(childStartPosition, childCount)
                }
            }
        }
    }
}