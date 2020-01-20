package com.yny.testcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class CalculatorTest {

    private val calculator: Calculator = Calculator()

//    @Before
//    fun setUp() {
//        calculator = Calculator()
//    }

    @Test
    fun add() {
        val result = calculator.add(12, 13)

        //使用hamcrest进行assert，直观，易读
        assertThat(result, `is`(equalTo(25)))
    }

}