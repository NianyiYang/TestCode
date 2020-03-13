package com.yny.testcode;

import com.yny.testcode.common.ListNode;

public class LinkListJava {

    /**
     * 237. 删除链表中的节点
     */
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * 141. 环形链表
     *
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     */
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        return false;
    }
}
