package com.leetcode.exercises;

/**
 * Logic to Solve this problem is Move the slow pointer by 1 step and Fast Pointer by 2 Steps
 * When Fast Pointer reaches the End of the list, the Slow Pointer will be at the Middle
 * If Fast Pointers next is pointing to Null then move the Slow pointer 1 step further and return it as Middle of list
 * 
 * 876. Middle of the Linked List  https://leetcode.com/problems/middle-of-the-linked-list/
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * 
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * 
 * 
 */
public class MiddleOfLinkedList {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val){this.val=val; }
		ListNode(int val, ListNode next){ this.val = val; this.next = next;}
		}
	

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		list.next.next.next.next.next = new ListNode(6);
		
		ListNode middle = middleNode(list);
		System.out.println(middle.val);
	}


	private static ListNode middleNode(ListNode head) {
		//If list is null then return null
		if(head ==null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		//Check whether we have reached end of the list and also whether we are moving out of the end of the list
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// return slow node as it is in the middle of the list
		return slow;
	}
	
	

}
