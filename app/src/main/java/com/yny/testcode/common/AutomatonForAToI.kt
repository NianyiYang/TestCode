package com.yny.testcode.common

/**
 * 字符串 转整数的自动机实现类
 *
 * 重点是建立自动机，整理出状态转移表
 */
class AutomatonForAToI {

    companion object {
        const val START = 0
        const val SIGNED = 1
        const val IN_NUMBER = 2
        const val END = 3
    }

    // 状态转移表
    private val stateMap = hashMapOf(
        Pair(START, intArrayOf(START, SIGNED, IN_NUMBER, END)),
        Pair(SIGNED, intArrayOf(END, END, IN_NUMBER, END)),
        Pair(IN_NUMBER, intArrayOf(END, END, IN_NUMBER, END)),
        Pair(END, intArrayOf(END, END, END, END))
    )

    // 初始状态
    private var state = START

    // 最终结果
    var result = 0

    // 正负号存为全局变量，判断溢出
    var isSign = true

    /**
     * 根据字符判断状态表中的 index
     */
    fun getIndex(char: Char) = when (char) {
        ' ' -> START
        '+', '-' -> SIGNED
        in '0'..'9' -> IN_NUMBER
        else -> END
    }

    /**
     * 状态转移函数实现
     */
    fun run(char: Char) {
        state = stateMap[state]?.get(getIndex(char)) ?: END
        when (state) {
            IN_NUMBER -> {
                // 状态到数字
                val currNumber: Int = char - '0'

                // TODO 这个越界判断有点看不明白
                if (result > (Int.MAX_VALUE - currNumber) / 10) {
                    result = if (isSign) Int.MAX_VALUE else Int.MIN_VALUE
                    // MB 直接强行结束自动机
                    state = END
                    return
                }
                result = result * 10 + currNumber
            }
            SIGNED -> {
                isSign = char == '+'
            }
        }
    }
}