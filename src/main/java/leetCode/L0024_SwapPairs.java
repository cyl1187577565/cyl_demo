package leetCode;

import lombok.Data;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/25
 */

/*给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

         

        示例:

        给定 1->2->3->4, 你应该返回 2->1->4->3.*/

public class L0024_SwapPairs {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;

        cur.next = new ListNode(3);
        cur = cur.next;

        cur.next = new ListNode(4);
        cur = cur.next;


        ListNode listNode = swapPairs(head);
        System.out.println(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode previous = res;
        ListNode cur = head;

        while (cur != null && cur.next != null){
            ListNode temPrevious = cur;
            ListNode tempCur = cur.next.next;
            ListNode next = cur.next;

            previous.next = next;
            next.next = cur;
            cur.next = tempCur;

            previous = temPrevious;
            cur = tempCur;
        }

        return res.next;
    }

    @Data
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
