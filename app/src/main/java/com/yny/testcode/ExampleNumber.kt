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
}