package com.zmm;

import com.zmm.entity.ListNode;

import java.util.LinkedList;
import java.util.Queue;

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例:
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
// Related Topics 堆 链表 分治算法
public class L23_MergekSortedLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(3);
        ListNode n = n1.next;
        n.next = new ListNode(6);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(1);
        n = n2.next;
        n.next = new ListNode(5);
        ListNode n3 = new ListNode(2);
        n3 = new L23_MergekSortedLists().mergeKLists(new ListNode[]{n1, n2});
        System.out.println(n3);
        Queue query = new LinkedList();
        query.poll();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        if(lists != null && lists.length > 0){
            ListNode temp = null;
            ListNode tempListNode = null;
            for (ListNode list : lists) {
                if(listNode == null){
                    listNode = list;
                }else{
                    temp = listNode;
                    while (temp != null && list != null){
                        if(list.val < temp.val){
                            tempListNode = new ListNode(list.val);
                            tempListNode.next = temp;
                            listNode = tempListNode;
                            temp = listNode;
                            list = list.next;
                            continue;
                        }else if(list.val == temp.val || (temp.next != null && temp.next.val >= list.val)){
                            tempListNode = new ListNode(list.val);
                            tempListNode.next = temp.next;
                            temp.next = tempListNode;
                            list = list.next;
                        }else if(temp.next == null){
                            temp.next = new ListNode(list.val);
                            list = list.next;
                        }
                        temp = temp.next;
                    }
                }
            }
        }
        return listNode;
    }
}
