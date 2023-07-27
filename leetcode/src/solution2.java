import java.util.LinkedList;

//两数相加
/*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class solution2 {
    public static void main(String[] args) {
        //构建list1
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(4, l3);
        ListNode list1 = new ListNode(2, l2);
        //构建list2
        ListNode L5 = new ListNode(9);
        ListNode L4 = new ListNode(4,L5);
        ListNode L3 = new ListNode(6, L4);
        ListNode list2 = new ListNode(5, L3);
        addTwoNumbers(list1,list2);
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0&&l2.val==0)return new ListNode(0);
        int num1 = 0, modCount1 = 1;
        int num2 = 0, modCount2 = 1;
        while(l1!=null){
            num1 += l1.val*modCount1;
            modCount1*=10;
            l1= l1.next;
//            if(l1!=null)

        }
        while (l2!=null){
            num2 += l2.val*modCount2;
            modCount2*=10;
            l2= l2.next;
        }
        int sum = num2 + num1;
        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode;
        while (sum!=0){
            int ge = sum % 10;
            ListNode node = new ListNode(ge, null);
            tail.next = node;
            tail = node;
            sum /= 10;
        }
        return listNode.next;
    }
}
