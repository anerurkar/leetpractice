package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 160. Intersection of Two Linked Lists 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
 * intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns
 * Custom Judge:
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node. 
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 *  
 * 
 */
public class IntersectionofTwoLinkedLists {
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 } 
	}
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(4);
		list1.next = new ListNode(1);
		list1.next.next = new ListNode(8);
		list1.next.next.next = new ListNode(4);
		list1.next.next.next.next = new ListNode(5);
		
		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(1);
		// The below is very important where the Node is Common
		list2.next.next.next = list1.next.next;
		list2.next.next.next.next = new ListNode(4);
		list2.next.next.next.next.next = new ListNode(5);
		
		System.out.println("Intersection Node is ");
		ListNode node = getIntersectionNode(list1, list2);
		System.out.println(node.val);
		
	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
		
}
