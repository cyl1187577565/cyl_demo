package leetCode;

/* 两数相加
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.*/
public class Aab_Add_Two_Numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = l1, q = l2, cur = head;
        int carry = 0;

        while ( p != null || q != null){
            int v1 = (p != null) ? p.val : 0;
            int v2 = (q != null) ? q.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum %10);
            cur = cur.next;
            if( p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }

        if(carry > 0){
            cur.next = new ListNode(carry);
        }

        return head.next;

    }
}

 class ListNode{
    int val;
    ListNode next;

     public ListNode(int value) {
         this.val = value;
     }
 }