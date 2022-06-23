package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * @author h104239
 *
 */
public class PalindromeInAList {

	/**
	 * Leetcode 234 - https://leetcode.com/problems/palindrome-linked-list/
	 * This is the Easiest approach
	 * Approach 1: Copy into Array List and then Use Two Pointer Technique
	 * Time complexity : O(n), where nn is the number of nodes in the Linked List.
	 * Space complexity : O(n), where nn is the number of nodes in the Linked List.
	 */
	public static boolean isPalindrome(ListNode head) {
		
		List<Integer> vals = new ArrayList<>();
		ListNode currentNode = head;
		//Convert LinkedList into ArrayList
		while(currentNode!=null) {
			vals.add(currentNode.data);
			currentNode = currentNode.next;
		}
		
		List<Integer> reverseLinkedList = new ArrayList<Integer>();
		// Reverse vals ArrayList
		for (int i = vals.size()-1; i >= 0 ; i--) {
			reverseLinkedList.add(vals.get(i));
		}
		
		//Check if the two array list are equal to each other
		for (int i = 0; i < vals.size()-1; i++) {
			if(!vals.get(i).equals(reverseLinkedList.get(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * This is a difficult approach
	 * First get the FirtHalfEnd and then get the Second Half Start by reversing the First Half so that
	 * we can check if the First Half and reverse of the 2nd Half are equal
	 * If they are equal then it is a Palindrome so compare all the values of both the Lists
	 * Now reverse the 2nd Half List and point the 1st Half End to it
	 * Thats It!	 * 
	 * Time Complexity is O(M)
	 * Space Complexity is O(1)
	 */
	public static boolean isPalindromeFastSlowPointerMethod(ListNode head) {
		
		if(head == null) return true;
		
		ListNode firstHaldEnd = reverseList(head);
		ListNode secondHalfStart = reverseList(firstHaldEnd.next);
		
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		// Compare the elements of 2nd Half with those of 1st Half whether they are equal
		while(result == true && p2!=null) {
			if(p1.data != p2.data) return false;
				p1 = p1.next;
				p2 = p2.next;			
		}
		// Correct the 2nd Half of the List as it was before
		firstHaldEnd = reverseList(secondHalfStart);
		return result;
	}
	
	/**
	 * Reverse a Linkedlist by pointing the head to null like curr.next = null
	 * and then pointing its next pointers to its previous noded by using
	 * a temp Node
	 * 
	 */
	public static ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode nextTmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTmp;
		}
		return prev;
	}
	
	/**
	 *  Return the place where slow has reached once fast reahces the end of the list
	 *  Because slow reaches at the middle of the List
	 */
	private ListNode endOffFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		
		ListNode node = head;
		for (int i=0; i < 5; i++) {
			if(node!=null)
				System.out.println("Actual List::" + node.data);
			node = node.getNext();
		}
		boolean isPalindrome = isPalindrome(head);
		boolean isPalindrome1 = PalindromeInAList.isPalindromeFastSlowPointerMethod(head);		
		System.out.println(isPalindrome);
		System.out.println(isPalindrome1);
	}
	
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

		public int getData() {
			return data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

	}

}
