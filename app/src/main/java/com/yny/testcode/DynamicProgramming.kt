package com.yny.testcode

import kotlin.math.max
import kotlin.math.min

/**
 * 动态规划相关
 *
 * 这里的所有题都用动态规划思想做
 */
class DynamicProgramming {
    /**
     * 53. 最大子序和
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    fun maxSubArray(nums: IntArray): Int {
        // 最优子结构
        // 重叠子问题
        val length = nums.size

        val dp = IntArray(length)
        dp[0] = nums[0]

        for (i in nums.indices) {
            if (i > 0) {
                dp[i] = max(dp[i - 1] + nums[i], nums[i])
            }
        }

        return dp.max() ?: 0
    }

    /**
     * 70. 爬楼梯
     */
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)

        for (i in 0..n) {
            when (i) {
                0 -> dp[i] = 0
                1 -> dp[i] = 1
                2 -> dp[i] = 2
                else -> dp[i] = dp[i - 1] + dp[i - 2]
            }
        }

        return dp[n]
    }

    /**
     * 198. 打家劫舍
     * 面试题 17.16. 按摩师
     */
    fun massage(nums: IntArray): Int {
        val length = nums.size

        if (length == 0) {
            return 0
        }

        val dp = IntArray(length)

        for (i in nums.indices) {
            when (i) {
                0 -> {
                    dp[i] = nums[i]
                }
                1 -> {
                    dp[i] = max(dp[0], nums[1])
                }
                else -> {
                    dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
                }
            }
        }

        return dp[dp.size - 1]
    }

    /**
     * 72. 编辑距离
     *
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     */
    fun minDistance(word1: String, word2: String): Int {
        // 构建DP数组 空字符需要单独考虑 所以长度都加1
        val row = word1.length + 1
        val col = word2.length + 1

        // kotlin 的二维数组初始化就是这么变态
        val dp = Array(size = row, init = { IntArray(col) })

        for (i in 0 until row) {
            dp[i][0] = i
        }

        for (j in 0 until col) {
            dp[0][j] = j
        }

        for (i in 1 until row) {
            for (j in 1 until col) {
                // 注意这里是判断上一个字符是否相同，来决定下一步操作
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
                }
            }
        }

        return dp[word1.length][word2.length]
    }
}