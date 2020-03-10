package com.yny.testcode

import java.util.*
import kotlin.Array

/**
 * 与广度优先搜索相关的题目
 */
class BreadthFirstSearch {

    /**
     * LeetCode 994. 腐烂的橘子
     *
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 输入：[[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     *
     * 输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     */
    fun orangesRotting(grid: Array<IntArray>): Int {

        // 行数和列数
        val row = grid.size
        val column = grid[0].size

        // 执行广度优先遍历
        // 构建一个队列存放该层遍历节点
        val queue: Queue<IntArray> = LinkedList()

        // 先假定第一个为腐烂的橘子
        // queue.push(intArrayOf(0, 0))

        // 遍历数据结构 找出所有新鲜橘子，计数；并找出所有腐烂橘子加入队列
        var freshOrangeCount = 0
        for (i in 0 until row) {
            for (j in 0 until column) {
                if (grid[i][j] == 1) {
                    freshOrangeCount++
                } else if (grid[i][j] == 2) {
                    queue.offer(intArrayOf(i, j))
                }
            }
        }

        // 记录遍历层数
        var depth = 0

        while (freshOrangeCount > 0 && queue.isNotEmpty()) {
            depth++

            // 将该层一次遍历完
            val size = queue.size
            for (i in 0 until size) {

                // 注意 poll 是队列出队方法 push 是栈出栈方法
                val cur = queue.poll()

                if(cur != null) {
                    val x = cur[0]
                    val y = cur[1]

                    println("output >> pos : ( $x , $y )  ${grid[x][y]}")

                    // 寻找 cur 的下层结点
                    // 左边，判断是否超过边界以及是否访问过，满足条件，加入queue
                    if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                        grid[x - 1][y] = 2
                        freshOrangeCount--
                        queue.offer(intArrayOf(x - 1, y))
                    }
                    // 上边 同理
                    if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                        grid[x][y - 1] = 2
                        freshOrangeCount--
                        queue.offer(intArrayOf(x, y - 1))
                    }
                    // 右边 同理
                    if (x + 1 < row && grid[x + 1][y] == 1) {
                        grid[x + 1][y] = 2
                        freshOrangeCount--
                        queue.offer(intArrayOf(x + 1, y))
                    }
                    // 下边 同理
                    if (y + 1 < column && grid[x][y + 1] == 1) {
                        grid[x][y + 1] = 2
                        freshOrangeCount--
                        queue.offer(intArrayOf(x, y + 1))
                    }
                }
            }
        }

        return if (freshOrangeCount > 0) -1 else depth
    }
}