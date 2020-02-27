package com.yny.testcode

/**
 * 链表相关
 *
 * @author nianyi.yang
 * @date 2020-01-20 19:34
 */
class LinkList {

    /**
     * 基本数据结构
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        var ln1 = l1
        var ln2 = l2

        // 哨兵节点
        val prevHead = ListNode(-1)

        // prev指针
        var prev: ListNode = prevHead

        while (ln1 != null && ln2 != null) {

            // 如果 1 小于 2
            if (ln1.`val` < ln2.`val`) {
                // prev 下一个结点指向 1
                prev.next = ln1
                // 1 前进
                ln1 = ln1.next
            } else {
                prev.next = ln2
                ln2 = ln2.next
            }

            // 结束后prev指向自己的下一个结点 前进
            prev = prev.next!!
        }

        // 收尾 如果哪一个还不为空 直接prev的next指向即可
        prev.next = ln1 ?: ln2

        return prevHead.next
    }
}