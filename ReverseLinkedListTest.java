package com.leetcode.exercises;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.leetcode.exercises.ReverseLinkedList.ListNode;

public class ReverseLinkedListTest {

	@Test
	public void iterativelyReverseListTestCase() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode node = ReverseLinkedList.reverseList(head);
		for (int i = 5; i >= 1; i--) {
			assertNotNull(node);
			assertEquals(i, node.data);
			System.out.println("Iterative: " + node.data);
			node = node.next;
		}
	}
	
	@Test
	public void RecursivelyReverseListTestCase() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode node = ReverseLinkedList.reverseListRecursively(head);
		for (int i = 5; i >= 1; i--) {
			assertNotNull(node);
			assertEquals(i, node.data);
			System.out.println("Iterative: " + node.data);
			node = node.next;
		}
	}
}
