package com.leetcode.exercises;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 589 : https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. 
 * Each group of children is separated by the null value (See examples)
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * 
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
public class NaryTreePreOrderTraversal {
	
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
	
	public static List<Integer> preorder(Node root){
		List<Integer> output = new ArrayList<>();
		helper(root,output);		
		return output;
	}
	
	public static void helper(Node root, List<Integer> output) {
		if(root == null) return;
		output.add(root.val);
		for(int i=0;i<root.children.size(); i++) {
			helper(root.children.get(i), output);
		}
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.children.add(new Node(3));
		root.children.add(new Node(2));
		root.children.add(new Node(4));
		root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
     
        List<Integer> output = preorder(root);
        List<Integer> actual = Arrays.asList(1,3,5,6,2,4);
        
        assertEquals(actual, output);
        
        for (Integer value : output) {
			System.out.print(value+" ");
		}
	}
}
