package com.leetcode.exercises;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	
	static final int COUNT = 10;
	
	// Write The Tree
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {}
		TreeNode(int val){ this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	static TreeNode invertTree(TreeNode root) {
		
		if(root!=null) {
			//invert the tree children
			invertTree(root.left);
			invertTree(root.right);
			
			//Swap the tree nodes
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
		}
		return root;
	}
	
	static TreeNode invertTreeIteratively(TreeNode root) {
		
		if(root!=null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				//Take out the Node and swap its left and right children
				TreeNode currentNode = queue.poll();
				TreeNode temp = currentNode.left;
				currentNode.left = currentNode.right;
				currentNode.right = temp;
				
				// Now add the rest of the nodes after Root into the queue
				if(currentNode.left != null) { queue.add(currentNode.left); }
				if(currentNode.right != null) { queue.add(currentNode.right); }
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new InvertBinaryTree.TreeNode(4);
		root.left = new InvertBinaryTree.TreeNode(2);
		root.right = new InvertBinaryTree.TreeNode(7);
		root.left.left = new InvertBinaryTree.TreeNode(1);
		root.left.right = new InvertBinaryTree.TreeNode(3);
		root.right.left = new InvertBinaryTree.TreeNode(6);
		root.right.right = new InvertBinaryTree.TreeNode(9);
		root = invertTree(root);
		print2DUtil(root,0);
		//root = invertTreeIteratively(root);
		//print2DUtil(root,0);
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
