package dataStruture.list;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/25
 */
public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i <= 100; i++) {
            Node temp = new Node(i);
            cur.next = temp;
            cur = temp;
        }

        System.out.println(">> 正常链表的样子:");
        printList(head);
        Node reverse = reverse3(head);
        System.out.println(">> 经过翻转之后链表的样子:");
        printList(reverse);
    }

    /**
     * 打印链表
     * @param head
     */
    private static void printList(Node head) {
        Node cur = head;

        StringBuilder sb = new StringBuilder();
        while (cur != null){
            if(cur.next == null){
                sb.append(cur.value);
            }else{
                sb.append(cur.value +" -> ");
            }
            cur = cur.next;
        }

        System.out.println(sb.toString());
    }


    //翻转列表第一种方法 三指针法 pre = null cur = head  next = null;
    public static Node reverse1(Node head) {

        //排除极端情况
        if(head == null || head.next == null){
            return head;
        }

        Node pre = null;
        Node cur = head;
        Node next;

        while (cur != null){
            next = cur.next;
            //翻转 pre 和 cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    //翻转列表第二种犯法    遍历链表 每次将当前指针插入head之后
    public static Node reverse2(Node head) {
        //排除特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head.next;
        Node secondNode = head.next;
        while (cur != null) {

            //临时变量用来记录 head节点当前的next节点,以及当前节点的next节点
            Node next = cur.next;
            Node headNext = head.next;

//            cur.next = null;
            //将当前节点插入到head节点之后
            head.next = cur ;
            cur.next = headNext;

            cur = next;
        }

        //  现在需要把head放到cur的后面
        Node res = head.next;
        head.next = null;
        secondNode.next = head;

        return res;
    }

    /**
     * 翻转链表方法三 先放入栈中， 然后在出栈
     * @param head
     * @return
     */
    public static Node reverse3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            stack.push(cur);

            cur = next;
        }


        Node res = new Node(null);
        cur = res;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }

        return res.next;
    }
}
