package com.zmm;

import com.zmm.entity.ListNode;

public class L25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(3);
        ListNode n = n1.next;
        n.next = new ListNode(5);
        n.next.next = new ListNode(6);
        n.next.next.next = new ListNode(7);
        n1 = new L25_ReverseNodesInKGroup().reverseKGroup(n1, 3);
        System.out.println(n1);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode temp = head.next;
        ListNode temp1 = new ListNode(head.val);
        ListNode temp2 = null;
        ListNode temp3 = temp1;
        int i = 1;
        while (temp != null && i < k){
            temp2 = new ListNode(temp.val);
            temp2.next = temp1;
            temp1 = temp2;
            temp = temp.next;
            i++;
            if(i == k){
                temp = reverseKGroup(temp, k);
                temp3.next = temp;
                head = temp1;
            }
        }
        return head;
    }
}
