package com.yny.testcode

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

        if(prices.size == 0) {
            return 0
        }

        // buy要在sell之前
        var buyPos = 0
        var sellPos = 0

        var buy = prices[0]
        var sell = -1

        for (i in 1 until prices.size) {
            if (buy > prices[i]) {
                buy = prices[i]
                buyPos = i
            }

            if (prices[i] > sell) {
                sell = prices[i]
                sellPos = i
            }
        }

        return if (sell - buy > 0 && buyPos < sellPos) sell - buy else 0
    }
}