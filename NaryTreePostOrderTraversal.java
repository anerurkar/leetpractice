package com.leetcode.exercises;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 590 : https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. 
 * Each group of children is separated by the null value (See examples)
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 5,6,3,2,4,1
 */
public class NaryTreePostOrderTraversal {
	
	public static class Node{
		
		int val;
		public List<Node> children = new ArrayList<>();
		
		public Node() {}
		
		public Node(int _val) { this.val = _val; }
		
		public Node(int _val, List<Node> children) { 
			this.val = _val; 
			this.children = children;
			}
	}
	
	public static List<Integer> postorder(Node root){
		List<Integer> output = new ArrayList<>();
		helper(root,output);		
		return output;
	}
	
	public static void helper(Node root, List<Integer> output) {
		if(root == null) return;
		for(int i=0;i<root.children.size(); i++) {
			helper(root.children.get(i), output);
		}
		output.add(root.val);		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.children.add(new Node(3));
		root.children.add(new Node(2));
		root.children.add(new Node(4));
		root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
     
        List<Integer> output = postorder(root);
        List<Integer> actual = Arrays.asList(5,6,3,2,4,1);
        
        assertEquals(actual, output);
        
        for (Integer value : output) {
			System.out.print(value+" ");
		}
	}
}
