package com.leetcode.exercises;

/**
 * 814. Binary Tree Pruning
 * https://leetcode.com/problems/binary-tree-pruning/
 * Given the root of a binary tree, return the same tree where every subtree (of
 * the given tree) not containing a 1 has been removed.
 * A subtree of a node node is node plus every node that is a descendant of
 * node.
 * 
 * Example 1:
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]  => 1 0 1
 * Explanation: 
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * 
 * Example 2:
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * Example 3:
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * 
 */
public class BinaryTreePruning {
	
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
		//root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		
		root = pruneTree(root);
		inOrder(root);
		
	}

	private static TreeNode pruneTree(TreeNode root) {
		
		if(root==null) return null;
		TreeNode output = new TreeNode(root.val);
		
		output.left = pruneTree(root.left);
		output.right = pruneTree(root.right);
		
		if(output.val==0 && output.left == null && output.right == null) {
			return null;
		}
		
		return output;
	}
	
	private static void inOrder(TreeNode node) {
	    if (node == null) {
	      return;
	    } 
	    inOrder(node.left);
	    System.out.printf("%s ", node.val);
	    inOrder(node.right);
	}

}
