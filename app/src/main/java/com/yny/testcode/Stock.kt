package com.yny.testcode

import kotlin.math.max

/**
 * 股票相关
 *
 * @author nianyi.yang
 * @date 2020-03-19 14:33
 */
class Stock {
    /**
     * 121. 买卖股票的最佳时机
     */
    fun maxProfit(prices: IntArray): Int {

        // 滑动窗口
        var buyPos = 0
        var sellPos = 0

        var value = 0

        for (i in prices.indices) {

            if (i == 0) {
                continue
            }

            if (prices[i - 1] < prices[i] && prices[sellPos] < prices[i]) {
                sellPos = i
            }
            if (prices[i - 1] >= prices[i] && prices[buyPos] >= prices[i]) {
                buyPos = i
                sellPos = i
            }

            value = max(prices[sellPos] - prices[buyPos],value)
        }

        return value
    }
}