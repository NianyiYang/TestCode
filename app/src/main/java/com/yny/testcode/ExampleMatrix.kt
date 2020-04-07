package com.yny.testcode

/**
 * 矩阵相关
 *
 * @author Yang
 * @date 2020.4.7 22:40
 */
class ExampleMatrix {

    /**
     * 面试题 01.07. 旋转矩阵
     *
     * 将矩阵旋转90°
     */
    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        var temp = 0

        // 因为只需要半边换一下
        val size: Int = matrix.size
        val halfSize: Int = matrix.size / 2

        // 先将矩阵水平对折
        for (i in 0 until halfSize) {
            for (j in matrix.indices) {
                temp = matrix[i][j]
                matrix[i][j] = matrix[size - 1 - i][j]
                matrix[size - 1 - i][j] = temp
            }
        }

        // 再将矩阵对角线对折
        // 先将矩阵水平对折
        for (i in matrix.indices) {
            for (j in i until size) {
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        return matrix
    }
}