package com.yny.testcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

/**
 * LeetCode
 *
 * @author nianyi.yang
 * @date 2020-01-20 19:29
 */
class LeetCodeTest {

    @Test
    fun addTwoNumber() {
        val addTwoNumber = AddTwoNumber()
        val result = addTwoNumber.twoSum(
            nums = intArrayOf(2, 7, 11, 15),
            target = 9
        )

        //使用hamcrest进行assert，直观，易读
        assertThat(result, `is`(intArrayOf(0, 1)))
    }

    @Test
    fun orangesRotting() {
        val breadthFirstSearch = BreadthFirstSearch()
        val result = breadthFirstSearch.orangesRotting(
            arrayOf(
                intArrayOf(1, 2)
            )
        )

        assertThat(result, `is`(1))
    }
}