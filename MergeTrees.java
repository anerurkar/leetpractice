package com.leetcode.exercises;

public class MergeTrees {

	static final int COUNT = 10;
	// BinaryTree
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(){}
		TreeNode(int val){ this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null) return null;
		if(root1 == null) return root2;
		if(root2 == null) return root1;
		
		TreeNode output = new TreeNode(root1.val+root2.val);
		output.left = mergeTrees(root1.left, root2.left);
		output.right = mergeTrees(root1.right, root2.right);
		return output;
	}
	
	public static void main(String[] args) {
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		
		TreeNode root = new TreeNode();
		root = mergeTrees(root1, root2);
		print2DUtil(root,0);

	}
	
	// Function to print binary tree in 2D
		// It does reverse inorder traversal
		static void print2DUtil(TreeNode root, int space) {
			if (root != null) {
				// Increase distance between levels
				space += COUNT;

				// Process right child first
				print2DUtil(root.right, space);

				// Print current node after space
				// count
				System.out.print("\n");
				for (int i = COUNT; i < space; i++)
					System.out.print(" ");
				System.out.print(root.val + "\n");

				// Process left child
				print2DUtil(root.left, space);
			}
		}
	
	

}
