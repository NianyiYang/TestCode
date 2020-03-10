package com.yny.testcode

import java.util.*
import kotlin.Array

/**
 * 滑动窗口算法
 */
class SlidingWindow {

    /**
     * 面试题57 - II. 和为s的连续正数序列
     *
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     **/
    fun findContinuousSequence(target: Int): Array<IntArray> {

        val resultList = mutableListOf<IntArray>()

        // target 小于 3
        if (target < 3) {
            return emptyArray()
        }

        val queue: Queue<Int> = LinkedList()
        queue.offer(1)
        queue.offer(2)

        var firstValue = 1
        var lastValue = 2

        while (queue.size >= 2) {
            // 先计算目前窗口中的值是否小于target
            val sum = queue.sum()

            when {
                sum < target -> // 如果小于，则窗口右端前移
                    queue.offer(++lastValue)
                sum > target -> {
                    // 如果大于，则窗口左端前移
                    queue.poll()
                    firstValue++
                }
                else -> {
                    // 相等的情况，加入数组
                    val result = IntArray(queue.size)
                    for (i in queue.indices) {
                        result[i] = queue.elementAt(i)
                    }
                    resultList.add(result)
                    queue.poll()
                    firstValue++
                }
            }
        }

        // list to array
        return if (resultList.isNotEmpty()) {
            resultList.toTypedArray()
        } else {
            emptyArray()
        }
    }

}