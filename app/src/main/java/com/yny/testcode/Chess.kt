package com.yny.testcode

class Chess {
    /**
     * 999. 车的可用捕获量
     */
    fun numRookCaptures(board: Array<CharArray>): Int {

        // 方向数组真的好用
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        var result = 0

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 'R') {
                    // 如果是 车 开始操作
                    for (k in 0 until 4) {
                        var nx = i + dx[k]
                        var ny = j + dy[k]

                        while (nx >= 0 && nx < board.size && ny >= 0 && ny < board[i].size) {
                            if (board[nx][ny] == 'B') {
                                break
                            }

                            if (board[nx][ny] == 'p') {
                                result++
                                break
                            }

                            nx += dx[k]
                            ny += dy[k]
                        }
                    }
                }
            }
        }

        return result
    }
}