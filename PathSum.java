package com.leetcode.exercises;

/**
 * https://leetcode.com/problems/path-sum/ 112. Path Sum 
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals
 * targetSum.
 * A leaf is a node with no children.
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * 
 */
public class PathSum {

	public static void main(String[] args) {
		
		int sum = 22;
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		System.out.println(hasPathSum(root, sum));
		
	}
	
	private static boolean hasPathSum(TreeNode root, int sum) {

		if(root == null) return false;
		if(root.left == null && root.right == null && root.val == sum) return true;
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}

	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			val = x;			
		}
		
	}

}
