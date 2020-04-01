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

    /**
     * 1160. 拼写单词
     *
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和
     */
    fun countCharacters(words: Array<String>, chars: String): Int {

        // 先把 chars 转成 map
        val charsMap = getMap(chars)

        var totalCount = 0

        // 遍历 words 列表
        for (word in words) {
            val wordMap = getMap(word)
            var singleCount = 0
            for (entry in wordMap) {
                if (charsMap.contains(entry.key) && entry.value <= charsMap.getValue(entry.key)) {
                    // 如果字母表中存在该字符，且该字符在该词中存在的数量比字母表少，则计数增加
                    singleCount += entry.value
                } else {
                    // 反之 singleCount 重置，并break
                    singleCount = 0
                    break
                }
            }

            totalCount += singleCount
        }

        return totalCount
    }

    private fun getMap(chars: String): HashMap<Char, Int> {
        val map = hashMapOf<Char, Int>()

        for (char in chars) {
            if (map.contains(char)) {
                var value = map.getValue(char)
                map[char] = ++value
            } else {
                map[char] = 1
            }
        }

        return map
    }

    /**
     * 409. 最长回文串
     */
    fun longestPalindrome(s: String): Int {
        val charMap = getMap(s)

        var count = 0

        for (entry in charMap) {
            if (entry.value > 1) {
                if (entry.value % 2 == 0) {
                    count += entry.value
                    entry.setValue(0)
                } else {
                    count += entry.value - 1
                    entry.setValue(1)
                }
            }
        }

        // 只遍历一次
        for (entry in charMap) {
            if (entry.value == 1) {
                count++
                break
            }
        }

        return count
    }

    /**
     * 1111. 有效括号的嵌套深度
     *
     * 1. 计算每个括号的嵌套深度
     * 2. 因为需要尽量均分，所以按 奇偶分配 #@%￥……￥&…… 什么鬼
     */
    fun maxDepthAfterSplit(seq: String): IntArray {
        // 存储括号深度
        val depthArray = IntArray(seq.length)

        // 模拟栈
        var stack = 0

        for (i in seq.indices) {
            val char = seq[i]
            if(char == '(') {
                stack++
                depthArray[i] = stack
            } else if(char == ')') {
                depthArray[i] = stack
                stack--
            }
        }

        for (i in depthArray.indices) {
            val depth = depthArray[i]
            // 对2取余即可分组
            depthArray[i] = depth % 2
        }

        return depthArray
    }
}