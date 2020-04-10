package com.yny.testcode

import java.util.*

class ExampleStack {
    /** initialize your data structure here. */
    private val stack: Stack<Int> = Stack()

    fun push(x: Int) {
        stack.push(x)
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return stack.min() ?: Int.MIN_VALUE
    }

    /**
     * 22. 括号生成
     */
    fun generateParenthesis(n: Int): List<String> {
        // 找到所有可能出现左括号的位置
        return mutableListOf()
    }
}