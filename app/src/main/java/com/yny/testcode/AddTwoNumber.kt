package com.yny.testcode

/**
 * No.1 两数之和
 *
 * @author nianyi.yang
 * @date 2020-01-20 19:26
 */
class AddTwoNumber {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        for(i in nums.indices) {
            for(j in i+1 until nums.size) {
                if(nums[i] + nums[j] == target) {
                    return intArrayOf(i,j)
                }
            }
        }

        return intArrayOf()
    }
}