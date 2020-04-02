package com.yny.testcode

import com.yny.testcode.common.Utils

class ExampleArray {
    /**
     * 三指针倒序遍历，原地操作，空间复杂度 O(1)
     **/
    fun merge(A: IntArray, m: Int, B: IntArray, n: Int) {
        var p = m - 1
        var q = n - 1
        var cur = m + n - 1

        // 只需要判断B数组指针位置
        while (q >= 0) {
            when {
                // A数组的指针指向-1时，直接将位置上填入B数组处的值即可
                p < 0 -> A[cur] = B[q--]
                A[p] < B[q] -> A[cur] = B[q--]
                else -> A[cur] = A[p--]
            }
            cur--
        }
    }

    /**
     * 169. 多数元素
     *
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
     *
     */
    fun majorityElement(nums: IntArray): Int {
        // 暴力哈希法
//        val map: MutableMap<Int, Int> = mutableMapOf()
//
//        for (num in nums) {
//            var count = map[num] ?: 0
//            map[num] = ++count
//        }
//
//        for (entry in map) {
//            if (entry.value > (nums.size / 2)) {
//                return entry.key
//            }
//        }
//
//        return 0

        // 分治法
//        return majorityElementRec(nums, 0, nums.size - 1)

        // Boyer-Moore 投票算法
        var count = 0
        var candi = nums[0]

        for (num in nums) {
            if (count == 0) {
                candi = num
            }

            if (num == candi) {
                count++
            } else {
                count--
            }
        }

        return candi
    }

    private fun majorityElementRec(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) {
            return nums[start]
        }

        val mid = (end - start) / 2 + start
        val left = majorityElementRec(nums, start, mid)
        val right = majorityElementRec(nums, mid + 1, end)

        return if (left == right) {
            left
        } else {
            // 这里拿全部的比较
            val leftCount = countInRange(nums, left, start, end)
            val rightCount = countInRange(nums, right, start, end)
            if (leftCount > rightCount) left else right
        }
    }

    private fun countInRange(nums: IntArray, target: Int, start: Int, end: Int): Int {

        var count = 0

        for (i in start..end) {
            if (nums[i] == target) {
                count++
            }
        }

        return count
    }

    /**
     * 53. 最大子序和
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     */
    fun maxSubArray(nums: IntArray): Int {
        // 滑动窗口 TODO 不行，这题不能用滑动窗口
//        var result = Int.MIN_VALUE
//
//        var p = 0
//        var q = 0
//
//        for (i in nums.indices) {
//            val temp = result
//            result = calcNum(nums, p, q)
//
//            if (temp >= result) {
//                p++
//            }
//            q++
//        }
//
//        return result
        return -1
    }

    /**
     * 914. 卡牌分组
     */
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        val map: HashMap<Int, Int> = HashMap()

        for (d in deck) {
            if (!map.contains(d)) {
                map[d] = 1
            } else {
                val value = map[d] ?: 1
                map[d] = value + 1
            }
        }

        if (map.isEmpty()) {
            return false
        }

        var minCount = Int.MAX_VALUE
        for (entry in map.entries) {
            if (minCount > entry.value) {
                minCount = entry.value
            }
        }

        var g = -1

        for (entry in map.entries) {

            // 这里要求所有count的最大公约数
            g = if (g == -1) {
                entry.value
            } else {
                Utils.gcd(entry.value, g)
            }
        }

        return g > 1
    }

    /**
     * 289. 生命游戏
     */
    fun gameOfLife(board: Array<IntArray>): Array<IntArray> {
        // 尝试使用空间复杂度为 O(1) 的方法
        // 给每一个元素增加十分位保存状态，十分位的数字代表它周围有多少个1

        // 新方法：八方向方向数组
        val dir = intArrayOf(0, -1, 1)

        for (i in board.indices) {
            for (j in board[i].indices) {

                for (m in dir.indices) {
                    for (n in dir.indices) {
                        val dx = i + dir[m]
                        val dy = j + dir[n]

                        if (dx >= 0 && dx < board.size && dy >= 0 && dy < board[i].size) {

                            if (dx == i && dy == j) {
                                continue
                            }

                            var origin = board[i][j]

                            // 这里要取余
                            if (board[dx][dy] % 10 == 1) {
                                origin += 10
                                board[i][j] = origin
                            }
                        }
                    }
                }

            }
        }

        // 第二步，根据题目规则重置面板状态
        for (i in board.indices) {
            for (j in board[i].indices) {
                val origin = board[i][j]

                // 注意 活细胞 仍然 存活 这个概念
                board[i][j] = when {
                    origin / 10 < 2 -> 0
                    origin / 10 == 2 -> origin % 10
                    origin / 10 == 3 -> 1
                    else -> 0
                }
            }
        }

        return board
    }
}