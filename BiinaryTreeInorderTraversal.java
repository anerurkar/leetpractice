package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example 1: Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 1: Input: root = []
 * Output: []
 * Example 3: Input: root = [1]
 * Output: [1]
 * 
 * Class Output: 
 * [1, 3, 2] 
 * [0]
 * [1]

 */
public class BiinaryTreeInorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(root));
		
		TreeNode root2 = new TreeNode();
		System.out.println(inorderTraversal(root2));
		
		TreeNode root3 = new TreeNode(1);
		System.out.println(inorderTraversal(root3));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		helper(root, output);
		return output;
	}

	private static void helper(TreeNode root, List<Integer> output) {
		if(root==null) return;
		helper(root.left,output);
		output.add(root.val);
		helper(root.right, output);
	}

}
