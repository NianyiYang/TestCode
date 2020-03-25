package com.yny.testcode

import kotlin.math.max

class Cubic {

    /**
     * 892. 三维形体的表面积
     */
    fun surfaceArea(grid: Array<IntArray>): Int {
        // 官方题解
        // 这个判断四边相邻的思路要学习
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        var result = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] > 0) {
                    result += 2

                    for (k in 0 until 4) {
                        val nx = i + dx[k]
                        val ny = j + dy[k]
                        var nv = 0

                        if (nx >= 0 && nx < grid.size && ny >= 0 && ny < grid[i].size) {
                            nv = grid[nx][ny]
                        }

                        result += max(grid[i][j] - nv, 0)
                    }
                }
            }
        }

        return result
    }
}