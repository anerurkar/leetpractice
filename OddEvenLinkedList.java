package com.leetcode.exercises;

/**
 * Leetcode 328: https://leetcode.com/problems/odd-even-linked-list/ 
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * Constraints:
 * n == number of nodes in the linked list
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 * 
 * Output::
 * Given Linked List
 * 1->2->3->4->5->NULL
 * Modified Linked List 
 * 1->3->5->2->4->NULL
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = newListNode(1);
	    head.next = newListNode(2);
	    head.next.next = newListNode(3);
	    head.next.next.next = newListNode(4);
	    head.next.next.next.next = newListNode(5);
	 
	    System.out.println("Given Linked List");
	    printlist(head);
	 
	    head = rearrangeEvenOdd(head);
	 
	    System.out.println("Modified Linked List");
	    printlist(head);
	}
	
	private static ListNode rearrangeEvenOdd(ListNode head) {
		if(head == null) return null;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode tmp = even;
		/**
		 * To Understand below logic imagine the following
		 * 1 -> 2 -> 3 -> 4 ->5 -> NULL
		 * Odd = head(1), even = head.next (2)
		 */
		while(even!=null && even.next!=null) {
			odd.next = even.next;  // 3
			odd = odd.next; // 3
			even.next = odd.next; // 4
			even = even.next; // 4
		}
		// Till Now Odd is exhausted, so it will now point to First Even element which is tmp
		odd.next = tmp; // 2
		return head;
	}

	static void printlist(ListNode node)
	{
	    while (node != null)
	    {
	        System.out.print(node.val + "->");
	        node = node.next;
	    }
	    System.out.println("NULL") ;
	}
	
	static ListNode newListNode(int key)
	{
		ListNode temp = new ListNode();
	    temp.val = key;
	    temp.next = null;
	    return temp;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val){ this.val = val; }
		ListNode(int val, ListNode next){this.val = val; this.next = next; }
	}

}
