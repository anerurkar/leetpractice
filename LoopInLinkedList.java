package com.leetcode.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * 
Given a linked list, determine if it has a cycle in it

Examples:
1) A → B → C → D - false
2) A → B → C → D -> E -> F -> C - true
With cycle


                  D
              ↗       ↘
   A → B → C             E 
              ↖       ↙
                  F
 *
 */
public class LoopInLinkedList {
	
	public static class Node{
		
		String data;
		//Node prev; // prev is used in Doubly linked list
		Node next;
		
		
		public Node(String data) {
			this.data = data;			
		}
		
		public Node(String data, Node next) {
			this.data = data;	
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) {
		
		Node node = new Node("A");
		node.next = new Node("B");
		node.next.next = new Node("C");
		node.next.next.next = new Node("D");
		node.next.next.next.next = new Node("E");
		node.next.next.next.next.next = new Node("F");
		//node.next.next.next.next.next.next = node.next.next; // Point to C
		
		Boolean isLoopPresent = findLoop(node);
		System.out.println("findLoopEasyWay isLoopPresent "+findLoopEasyWay(node));
		System.out.println("findLoop isLoopPresent "+isLoopPresent);
	}
	
	private static Boolean findLoopEasyWay(Node head) {
		
		Set<Node> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			}
			nodesSeen.add(head);
			head = head.next;
		}
		return false;
	}

	private static Boolean findLoop(Node node) {
		
		Node slow  = node.next;
		Node fast  = slow.next;
		
		if(slow == null || fast == null) return false;
		
		if(node.next==null) return false;
		while (node.next != null) {
			if (slow == fast) {
				return true;
			} else if(fast == null){
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
	}
	
	
	
}
