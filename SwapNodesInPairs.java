package com.leetcode.exercises;

/**
 * 24 Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 * Input: head = []
 * Output: []
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * 
 */
public class SwapNodesInPairs {
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 } 
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(3);
		list1.next.next.next = new ListNode(4);
		System.out.println("Input List is ::");
		printListNode(list1);
		System.out.println();
		System.out.println("Output List is ::");
		
		list1 = swapPairs(list1);
		printListNode(list1);
		
	}

	private static void printListNode(ListNode list1) {
		while(list1!=null) {
			System.out.print(list1.val+" ");
			list1 = list1.next;
		}
	}

	private static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int tmp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = tmp;
            cur = cur.next.next;
        }
        return head;  
	}
}
