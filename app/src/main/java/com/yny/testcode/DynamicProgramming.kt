package com.yny.testcode

import kotlin.math.max

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

        if(length == 0) {
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
}