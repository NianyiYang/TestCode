package com.yny.testcode

import java.util.*

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

                if (cur != null) {
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

    /**
     * 1162. 地图分析
     */
    fun maxDistance(grid: Array<IntArray>): Int {
        // 多源广度优先遍历

        // 首先找出所有陆地，加入队列
        val queue: Queue<IntArray> = LinkedList()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    queue.offer(intArrayOf(i, j))
                }
            }
        }

        // 没有陆地
        if (queue.isEmpty()) {
            return -1
        }

        // 又用到方向数组
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        // 一个标识，判断是否存在海洋
        var hasOcean = false
        var depth = 0

        // 开始针对每一个陆地，向海洋扩散
        while (queue.isNotEmpty()) {
            val point = queue.poll()
            val x = point!![0]
            val y = point[1]

            for (k in 0 until 4) {
                val nx = x + dx[k]
                val ny = y + dy[k]

                if (nx >= 0 && nx < grid.size && ny >= 0 && ny < grid[0].size) {
                    if (grid[nx][ny] == 0) {
                        // 表示是海洋 还未被访问
                        grid[nx][ny] = grid[x][y] + 1
                        // 并将该点加入队列
                        queue.offer(intArrayOf(nx, ny))
                        // 存在海洋
                        hasOcean = true
                        // depth
                        depth = grid[nx][ny]
                    }
                }
            }
        }

        if (!hasOcean) {
            return -1
        }

        return depth - 1
    }
}