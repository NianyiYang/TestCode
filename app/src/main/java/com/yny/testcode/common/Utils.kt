package com.yny.testcode.common

object Utils {
    /**
     * 辗转相除法，求最大公约数
     */
    fun gcd(a: Int, b: Int): Int {
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
}