package com.example.zzw.expand.model

open class TreeViewModel {
    /**
     * item类型：父节点/子节点，如果不用MultiTypeAdapter管理类型，可以用此变量标识类型
     */
    var itemType: Int = 0

    /**
     * 层级深度，用于控制不同层级的view的左侧空出多少留白
     */
    var treeDepth: Int = 0

    /**
     * 是否展开
     */
    var expand: Boolean = false

    /**
     * 携带的子节点
     */
    var children: ArrayList<TreeViewModel>? = null

    companion object {
        /**
         * 父节点
         */
        const val ITEM_TYPE_PARENT = 0

        /**
         * 子节点
         */
        const val ITEM_TYPE_CHILD = 1

        /**
         * 获取显示中的子节点
         */
        fun getChildCountForHide(item: TreeViewModel): Int {
            val list = ArrayList<TreeViewModel>()
            printChild(item, list)
            return list.size - 1
        }

        private fun printChild(item: TreeViewModel, list: ArrayList<TreeViewModel>) {
            list.add(item)
            if (item.expand) {
                item.children?.forEach {
                    printChild(it, list)
                }
            }
        }
    }
}