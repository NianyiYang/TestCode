package com.yny.testcode

class InstanceArray {
    /**
     * 三指针倒序遍历，原地操作，空间复杂度 O(1)
     **/
    fun merge(A: IntArray, m: Int, B: IntArray, n: Int) {
        var p = m - 1
        var q = n - 1
        var cur = m + n - 1

        // 只需要判断B数组指针位置
        while (q >= 0) {
            when {
                // A数组的指针指向-1时，直接将位置上填入B数组处的值即可
                p < 0 -> A[cur] = B[q--]
                A[p] < B[q] -> A[cur] = B[q--]
                else -> A[cur] = A[p--]
            }
            cur--
        }
    }
}