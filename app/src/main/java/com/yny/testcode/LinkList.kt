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

    /**
     * 反转一个单链表
     */
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head

        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        return prev
    }

    /**
     * 2. 两数相加
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null && l2 == null) {
            return null
        } else {

            val prevHead = ListNode(-1)

            // 将头结点连接起来
            var curr = prevHead

            var p = l1
            var q = l2

            var carry = 0

            while (p != null || q != null) {
                val result = (p?.`val` ?: 0) + (q?.`val` ?: 0) + carry

                curr.next = ListNode(result % 10)

                carry = result / 10

                if (p != null) {
                    p = p.next
                }
                if (q != null) {
                    q = q.next
                }

                curr = curr.next!!
            }

            // 处理最后一个进位
            if (carry == 1) {
                curr.next = ListNode(carry)
            }

            return prevHead.next
        }
    }
}