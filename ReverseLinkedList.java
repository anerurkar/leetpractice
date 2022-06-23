package com.leetcode.exercises;

/**
 * 
 * @author Sikandar
 * 
 * Program to reverse a linkedlist using iterative and recursive methods
 * Input: 1 2 3 4 5
 * Output::
 * Iterative: 5
 * Iterative: 4
 * Iterative: 3
 * Iterative: 2
 * Iterative: 1
 *
 */
public class ReverseLinkedList {
	
	public static class ListNode {
		
		int data;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int data) {
			this.data = data;
		}

		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * Iterative method 
	 * 
	 * While you are traversing the list, change the current node's next pointer to point to its previous element. 
	 * Since a node does not have reference to its previous node, you must store its previous element beforehand. 
	 * You also need another pointer to store the next node before changing the reference. 
	 * Do not forget to return the new head reference at the end!
	 * 
	 * Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).
	 * Space complexity : O(1).
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
	
	/**
	 * Recursive Method
	 * 
	 * The recursive version is slightly trickier and the key is to work backwards. 
	 * Assume that the rest of the list had already been reversed, 
	 * now how do I reverse the front part? Let's assume the list is: 
	 * n1 → … → nk-1 → nk → nk+1 → … → nm → Ø

	 * Assume from node nk+1 to nm had been reversed and you are at node nk.
	 * n1 → … → nk-1 → nk → nk+1 ← … ← nm
	 * We want nk+1’s next node to point to nk.
	 * So, nk.next.next = nk;
	 * Be very careful that n1's next must point to Ø. If you forget about this, 
	 * your linked list has a cycle in it. This bug could be caught 
	 * if you test your code with a linked list of size 2.
	 * 
	 * Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
	 * Space complexity : O(n). The extra space comes from implicit stack space due to recursion. 
	 * The recursion could go up to n levels deep.
	 */
	public static ListNode reverseListRecursively(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = reverseListRecursively(head.next);
		head.next.next = head;
		head.next = null;
		
		return p;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		//ListNode node = ReverseLinkedList.reverseList(head);
		ListNode node = ReverseLinkedList.reverseListRecursively(head);
		for (int i = 5; i >= 1; i--) {
			System.out.println("Iterative: " + node.data);
			node = node.next;
		}
	}

}
