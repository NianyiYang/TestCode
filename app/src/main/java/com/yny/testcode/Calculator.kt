package com.yny.testcode

/**
 * 单元测试模拟
 *
 * @author nianyi.yang
 * @date 2020-01-20 19:17
 */
class Calculator {

    /**
     * 两数相加
     */
    fun add(value1: Int, value2: Int): Int {
        return value1 + value2
    }

    /**
     * 70. 爬楼梯
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    fun climbStairs(n: Int): Int {
        // 可以用动态规划但是我不知道动态规划怎么写
        return fibonacci(n, 1, 2)
    }

    private fun fibonacci(n: Int, first: Int, second: Int): Int {
        return when (n) {
            1 -> first
            else -> fibonacci(n - 1, second, first + second)
        }
    }
}