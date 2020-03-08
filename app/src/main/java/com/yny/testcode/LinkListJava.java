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
}
