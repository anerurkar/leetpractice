package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * 
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed)
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 */
public class FindLargestValueInEachTreeRow {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		
		List<Integer> largestValInEachTreeRow =  largestValues(root);
		System.out.print("[");
		for (Integer integer : largestValInEachTreeRow) {
			System.out.print(integer+",");
		}
		System.out.print("]");
	}

	private static List<Integer> largestValues(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		helper(root, output, 0);
		return output;
	}

	private static void helper(TreeNode root, List<Integer> output, int level) {
		if(root == null) return;
		
		if(level == output.size()) {
			output.add(root.val);
		} else {
			output.set(level, Math.max(output.get(level), root.val));
		}
		
		helper(root.left, output, level+1);
		helper(root.right, output, level+1);
		
	}

}
