package com.yny.testcode

import kotlin.math.min

class ExampleString {

    /**
     * 1071. 字符串的最大公因子
     *
     * 方法1 暴力枚举
     */
    fun gcdOfStrings(str1: String, str2: String): String {
        val length1 = str1.length
        val length2 = str2.length

        val minSize = min(length1, length2)

        // 从大到小的原因是为了找出最大子字符串
        for (i in minSize downTo 1) {
            if (length1 % i == 0 && length2 % i == 0) {
                val x = str1.substring(0, i)
                if (checkStringEqual(str1, x) && checkStringEqual(str2, x)) {
                    return x
                }
            }
        }

        return ""
    }

    /**
     * 如果 p 经过 n 次拼接等于 s 说明是子字符串
     *
     * @param s 主字符串
     * @param p 子字符串
     */
    private fun checkStringEqual(s: String, p: String): Boolean {

        var temp = p

        while (temp.length < s.length) {
            temp += p
        }

        return s == temp
    }

    /**
     * 枚举优化（辗转相除法）
     * 如果存在一个符合要求的字符串 X，那么也一定存在一个符合要求的字符串 X'，它的长度为 str1 和 str2 长度的最大公约数。
     */
    fun gcdOfStrings2(str1: String, str2: String): String {
        val length1 = str1.length
        val length2 = str2.length

        val x = str1.substring(0, gcd(length1, length2))
        if (checkStringEqual(str1, x) && checkStringEqual(str2, x)) {
            return x
        }

        return ""
    }

    /**
     * 辗转相除法，求最大公约数
     */
    private fun gcd(a: Int, b: Int): Int {
//        // 非递归
//        var tempA = if (a > b) a else b
//        var tempB = if (a > b) b else a
//
//        while (tempB != 0) {
//            val temp = tempB
//            tempB = tempA % tempB
//            tempA = temp
//        }
//
//        return tempA

        // 递归 必须 a>b
        return if (b == 0) a else gcd(b, a % b)
    }

    /**
     * 数学方法
     * 如果 str1 和 str2 拼接后等于 str2和 str1 拼接起来的字符串（注意拼接顺序不同），那么一定存在符合条件的字符串
     * 反之，则不存在
     */
    fun gcdOfStrings3(str1: String, str2: String): String {

        if (str1 + str2 != str2 + str1) {
            return ""
        }

        return str1.substring(0, gcd(str1.length, str2.length))
    }
}