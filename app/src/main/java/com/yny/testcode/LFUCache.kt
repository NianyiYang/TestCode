package com.yny.testcode

import java.util.*
import kotlin.collections.HashMap

/**
 * 460. LFU 缓存
 *
 * LFU 最不经常使用：这个缓存算法使用一个计数器来记录条目被访问的频率。通过使用LFU缓存算法，最低访问数的条目首先被移除
 * LRU 最近最少使用：这个缓存算法将最近使用的条目存放到靠近缓存顶部的位置。当一个新条目被访问时，LRU将它放置到缓存的顶部。当缓存达到极限时，较早之前访问的条目将从缓存底部开始被移除
 */
class LFUCache(capacity: Int) {

    private val cache = HashMap<Int, Node>(capacity)

    private val freqMap = HashMap<Int, LinkedHashSet<Node>>()

    private val total = capacity

    // 存储当前最小频次
    private var min = Int.MIN_VALUE

    fun get(key: Int): Int {
        if (cache.contains(key)) {
            val node = cache[key]

            if (node != null) {
                freqInc(node)
                return node.value
            }
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key]

            if (node != null) {
                node.value = value
                freqInc(node)
            }
        } else {
            // 判断缓存是否达到上限
            if (cache.size == total) {
                // 如果达到上限。
                val deadNode = removeNode()
                deadNode?.let {
                    cache.remove(deadNode.key)
                }

            }

            if (total > 0) {
                val newNode = Node(key, value)
                cache[key] = newNode
                addNode(newNode)
            }
        }
    }

    fun freqInc(node: Node) {
        // 从原freq对应的链表里移除, 并更新min
        var freq = node.freq
        var set: LinkedHashSet<Node>? = freqMap[freq]
        // ??? 为什么remove不掉
        set?.remove(node)
        if (freq == min && set?.size == 0) {
            min = freq + 1
        }
        // 加入新freq对应的链表
        node.freq++
        var newSet = freqMap[freq + 1]
        if (newSet == null) {
            newSet = LinkedHashSet()
            freqMap[freq + 1] = newSet
        }
        newSet.add(node)
    }

    fun addNode(node: Node) {
        var set = freqMap[1]
        if (set == null) {
            set = LinkedHashSet()
            freqMap[1] = set
        }
        set.add(node)
        min = 1
    }

    fun removeNode(): Node? {
        val set = freqMap[min]
        val deadNode = set?.iterator()?.next()
        set?.remove(deadNode)
        return deadNode
    }

    // CTMB 的 data class... FUCK!!!
    // 很坑的一点是 data class每次都是创建一个新对象，导致 remove 失效
    // data class Node(val key: Int, var value: Int, var freq: Int = 1)
    class Node(val key: Int, var value: Int, var freq: Int = 1)
}
