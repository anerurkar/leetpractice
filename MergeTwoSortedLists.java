package com.leetcode.exercises;

/**
 * Logic to merge the two linked lists is to create a temporary list 
 * Now compare the first nodes of both the lists and add the smaller one to the output List
 * Since first list node is smaller, we can add it
 * Now compare the second node of first list to 1st node of 2nd and add the smaller one to output list
 * Keep on doing this until all nodes are exhausted and return the Output list 
 * If anyone of the list is of Smaller length, meaning the nodes are less than the other list
 * And If there are still nodes left in any of the two lists then just add them at the end of Output list
 * 
 * 21. Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists/
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing 
 * together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 */
public class MergeTwoSortedLists {
	
	static class ListNode{
		
		int val;
		ListNode next;
		ListNode(){};
		ListNode(int val){this.val = val;};
		ListNode(int val, ListNode next){ this.val = val; this.next = next;};
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode mergedList = mergeTwoLists(list1, list2);
		printList(mergedList);
	}

	private static void printList(ListNode list) {
		while(list!=null) {
			System.out.print(list.val+",");
			list = list.next;
		}
		
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//Create a temporary list to store the merged lists
		ListNode tmp = new ListNode(0);
		//create a pointer to the head of the output list so that we can keep on adding in it
		ListNode output = tmp;
		
		while(l1!=null && l2!=null) {
			if(l1.val > l2.val) {
				tmp.next = l2;
				l2 = l2.next;
			} else {
				tmp.next = l1;
				l1 = l1.next;				
			}
			tmp = tmp.next;
			
		}
		
		if(l1!=null) {
			tmp.next = l1;
		}
		if(l2!=null) {
			tmp.next = l2;
		}
		//Since we had added a dummy 0 when we created the tmp List to whose head Output is pointing
		// Hence we will just return the next of Output so that we can ignore this 0 which we had added temprarily
		return output.next;
	}

}
