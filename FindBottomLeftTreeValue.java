package com.leetcode.exercises;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513 https://leetcode.com/problems/find-bottom-left-tree-value/
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * Example 1:
 * Input: root = [2,1,3]
 * Output: Leftmost leaf node is 1
 * Example 2:
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * 
 */
public class FindBottomLeftTreeValue {
	
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
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		int bottomMostLeftNode = findBottomLeftValue(root);
		System.out.println("Leftmost leaf node is "+bottomMostLeftNode);
	}

	private static int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			root = queue.poll();
			if(root.right!=null) queue.add(root.right);
			if(root.left!=null) queue.add(root.left);
		}
		return root.val;
	}
}
