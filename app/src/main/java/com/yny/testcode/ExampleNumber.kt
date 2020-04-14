package com.yny.testcode

class ExampleNumber {

    /**
     * 7. 整数反转
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     */
    fun reverse(x: Int): Int {

        var origin = x

        var result = 0

        while (origin != 0) {
            val cur = origin % 10
            origin /= 10

            // 这里要考虑溢出的情况 cur 7 与 -8 都是边界条件
            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && cur > 7)) {
                return 0
            }

            if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && cur < -8)) {
                return 0
            }

            result = result * 10 + cur
        }

        return result
    }

    /**
     * 263. 丑数
     *
     * 编写一个程序判断给定的数是否为丑数。
     *
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     */
    fun isUgly(num: Int): Boolean {

        var temp = num

        if (temp == 1) {
            return true
        } else if (temp % 2 != 0 && temp % 3 != 0 && temp % 5 != 0) {
            return false
        } else {
            while (temp != 0 && temp % 2 == 0) {
                temp /= 2
            }

            while (temp != 0 && temp % 3 == 0) {
                temp /= 3
            }

            while (temp != 0 && temp % 5 == 0) {
                temp /= 5
            }
        }

        return temp == 1
    }

    /**
     * 136. 只出现一次的数字
     *
     * 要求 线性时间复杂度 空间复杂度为O(1)
     */
    fun singleNumber(nums: IntArray): Int {

        // 方法1 HashMap
        // 方法2 2 * (a+b+c) - (a+a+b+b+c) = c
        // 方法3 通过异或 a xor b xor a = b
        // 异或 满足 交换律 和 结合律
        var result = 0

        for (i in nums) {
            result = result xor i
        }

        return result
    }

    /**
     * 面试题62. 圆圈中最后剩下的数字
     * 約瑟夫環
     */
    fun lastRemaining(n: Int, m: Int): Int {
        return ring(n, m)
    }

    private fun ring(n: Int, m: Int): Int {
        return if (n == 1) {
            0
        } else {
            val x = ring(n - 1, m)
            (m + x) % n
        }
    }

    /**
     * 15. 三数之和
     */
    fun threeSum(nums: IntArray): List<List<Int>> {

//        val resultSet = HashSet<List<Int>>()
//
//        // p1 第一个的位置 p2 第一个的值 p3 第二个的位置 p4 第二个的值
//        val matched = mutableListOf<IntArray>()
//
//        // 先正向排序，剪枝
//        val sortedNums = nums.sorted()
//
//        // 如果数组为空，或者排序后第一个就为正数，则不用往下算了
//        if (sortedNums.isEmpty() || sortedNums[0] > 0) {
//            return mutableListOf()
//        }
//
//        for (i in sortedNums.indices) {
//            for (j in i + 1 until sortedNums.size) {
//                // 如果 i,j 处的数据都大于 0 ，则不用加入数组了
//                if (sortedNums[i] > 0 && sortedNums[j] > 0) {
//                    break
//                } else {
//                    matched.add(intArrayOf(i, sortedNums[i], j, sortedNums[j]))
//                }
//            }
//        }
//
//        for (k in 2 until sortedNums.size) {
//            for (l in matched) {
//                if (k != l[0] && k != l[2] && sortedNums[k] + l[1] + l[3] == 0) {
//                    resultSet.add(listOf(l[1], l[3], sortedNums[k]).sorted())
//                }
//            }
//        }
//
//        return resultSet.toList()

        if (nums.isEmpty() || nums.size < 3) {
            return mutableListOf()
        }

        val result = mutableListOf<List<Int>>()

        // 正向排序
        nums.sort()

        for (i in nums.indices) {
            // 定义双指针
            var start = i + 1
            var end = nums.size - 1

            // 因为是正向排序的
            // 所以nums[i] > 0 表示后面无论怎么加都 > 0 不需要算
            if (nums[i] > 0) {
                break
            }

            // 这个判断条件要加 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            while (start < end) {

                if (nums[i] + nums[start] + nums[end] == 0) {
                    // 符合条件
                    result.add(
                        listOf(
                            nums[i],
                            nums[start],
                            nums[end]
                        )
                    )

                    // 排除重复的情况
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++
                    }

                    // 同上
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--
                    }

                    start++
                    end--

                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    // 和 小于 0 左指针右移
                    start++
                } else {
                    // 和 大于 0 右指针左移
                    end--
                }
            }
        }

        return result
    }

    /**
     * 17. 电话号码的字母组合
     */
    fun letterCombinations(digits: String): List<String> {
        val map = hashMapOf(
            Pair(2, arrayOf('a', 'b', 'c')),
            Pair(3, arrayOf('d', 'e', 'f')),
            Pair(4, arrayOf('g', 'h', 'i')),
            Pair(5, arrayOf('j', 'k', 'l')),
            Pair(6, arrayOf('m', 'n', 'o')),
            Pair(7, arrayOf('p', 'q', 'r', 's')),
            Pair(8, arrayOf('t', 'u', 'v')),
            Pair(9, arrayOf('w', 'x', 'y', 'z'))
        )

        val seqs = mutableListOf<Array<Char>>()

        for (digit in digits) {
            val number = digit.toInt()
            if(map.contains(number)) {
                seqs.add(map[number]!!)
            }
        }

        calc(seqs)

        return listOf()
    }

    private fun calc(seqs: MutableList<Array<Char>>) {
        if (seqs.isNullOrEmpty()) {
            return
        }

        while (seqs)
    }
}