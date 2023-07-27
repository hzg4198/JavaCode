
import java.util.ArrayList;
import java.util.List;

//合并两个有序链表 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
/*
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
输入：l1 = [1,2,4], l2 = [1,3,4]输出：[1,1,2,3,4,4]
 */
public class solution21 {
    public static void main(String[] args) {
        //构建list1
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode list1 = new ListNode(1, l2);
        //构建list2
        ListNode L4 = new ListNode(4);
        ListNode L3 = new ListNode(3, L4);
        ListNode list2 = new ListNode(1, L3);
        //空node
        ListNode node = null;
        mergeTwoLists(list1,list2);


    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
   /*     ListNode listNode =new ListNode(0,null);
        List<Integer> list = new ArrayList<>();
        while(list1!=null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while ((list2!=null)){
            list.add(list2.val);
            list2 = list2.next;
        }
        list.sort((o1, o2) -> o2-o1);//逆序排序
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i),listNode.next);
            listNode.next = node;

        }
        return listNode.next;*///转化为降序数组后用头插法
        //迭代 尾插法
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
//                ListNode s = new ListNode(list1.val,null);//根本不用新创建结点
                tail.next = list1;
                list1 = list1.next;
            }else {
//                ListNode s = new ListNode(list2.val, null);
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }




}
