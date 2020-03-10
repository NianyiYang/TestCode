package com.yny.testcode

import kotlin.math.max

/**
 * 二叉树相关
 *
 * @author nianyi.yang
 * @date 2020-03-10 16:06
 */
class BinaryTree {
    /**
     * 543. 二叉树的直径
     *
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * 注意：最大值不一定要包含根节点
     */
    private var diam:Int = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return diam
    }

    private fun dfs(root: TreeNode?): Int {
        // 很明显的递归
        if (root == null) {
            return 0
        }

        val leftDiam = dfs(root.left)
        val rightDiam = dfs(root.right)

        diam = max(diam, leftDiam + rightDiam)

        return max(leftDiam, rightDiam) + 1
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}