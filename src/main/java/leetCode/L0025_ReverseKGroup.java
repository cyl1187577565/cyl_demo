package leetCode;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/25
 */

/*给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

        k 是一个正整数，它的值小于或等于链表的长度。

        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

        示例 :

        给定这个链表：1->2->3->4->5

        当 k = 2 时，应当返回: 2->1->4->3->5

        当 k = 3 时，应当返回: 3->2->1->4->5

        说明 :

        你的算法只能使用常数的额外空间。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/

public class L0025_ReverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();

        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode previous = res;
        ListNode start = head;
        //寻找第一组最后一个
        ListNode end = findKNode(start, k);

        while (end != null){
            ListNode next = end.next;
            //翻转列表
            reverse(start,end,previous,next,stack);

            previous = start;
            start = previous.next;
            end = findKNode(start, k);

        }

        return res.next;
    }

    public static void reverse(ListNode start, ListNode end, ListNode previous, ListNode next, LinkedList<ListNode> stack) {

        ListNode cur = start;
        stack.push(cur);
        while (cur != end){
            cur = cur.next;
            stack.push(cur);
        }

        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            previous.next = pop;
            previous = pop;
        }

        previous.next = next;
    }

    /**
     * 查找第K个node
     */
    public static ListNode findKNode(ListNode head, int k) {
        int i = 1;
        ListNode cur = head;
        while (cur != null){
            if(i == k){
                return cur;
            }
            cur = cur.next;
            i++;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;

        cur.next = new ListNode(3);
        cur = cur.next;

        cur.next = new ListNode(4);
        cur = cur.next;

        cur.next = new ListNode(5);
        cur = cur.next;

         reverseKGroup(head, 2);

    }
}
