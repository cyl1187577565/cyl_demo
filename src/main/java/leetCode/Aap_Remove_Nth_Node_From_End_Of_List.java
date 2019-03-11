package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 19删除链表的倒数第N个数
 */
public class Aap_Remove_Nth_Node_From_End_Of_List {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer , List<ListNode>> map = new HashMap<>();
        ListNode cur = head;
        ListNode pre = null;
        int i = 0;

        while (cur != null){
            ListNode tempPre = pre;
            ListNode temp = cur;
            List<ListNode> tempList = new ArrayList<>();
            tempList.add(tempPre);
            tempList.add(cur);
            map.put(i,tempList);
            i++;
            pre = cur;
            cur = cur.next;
        }

        List<ListNode> listNodes = map.get(i - n + 1);
        if (listNodes != null && listNodes.size() > 0){
            pre = listNodes.get(0);
            cur = listNodes.get(1);
            if(pre == null){
                return cur.next;
            }else{
                pre.next = cur.next;
                cur = null;
            }
        }
        return head;
    }
}
