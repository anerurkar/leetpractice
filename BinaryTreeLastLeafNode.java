package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * JPMC Bangalore 2nd round interview questions
 * Binary Tree 
 * we need to find the last leaf nodes 
 * which are at the same level
 * 			1(Root)
 * 	2	    		3		   
	5	 	6   	7     8
        	  		9	10
        	  	  11(Last Leaf Node)
		Print 9 as part of this Program				
 * 
 * @param args
 */
public class BinaryTreeLastLeafNode {
	
	public static void main(String[] args) {
		
		BinaryTree root = new BinaryTree(1,1);
		root.left = new BinaryTree(2,2);
		root.right = new BinaryTree(3,2);
		root.left.left = new BinaryTree(5,3);
		root.left.right = new BinaryTree(6,3);
		root.right.left = new BinaryTree(7,3);
		root.right.right = new BinaryTree(8,3);
		root.right.right.left = new BinaryTree(9,4);
		root.right.right.right = new BinaryTree(10,4);
		root.right.right.left.left = new BinaryTree(11,5);
		
		List<BinaryTree> leafNodesList = new ArrayList<>();
		leafNodesList = findLastLeafNode(root, leafNodesList);
		
		Map<Integer, Integer> levelAndDataMap = new HashMap<>();
		
		for (int i = 0; i < leafNodesList.size(); i++) {
			levelAndDataMap.put(leafNodesList.get(i).getData(), leafNodesList.get(i).getLevel());
		}
		
		int maxValueInMap=(Collections.max(levelAndDataMap.values()));  // This will return max value in the HashMap
        for (Entry<Integer, Integer> entry : levelAndDataMap.entrySet()) {  // Iterate through HashMap
            if (entry.getValue()==maxValueInMap) {
                System.out.println("The last leaf node is "+entry.getKey() + " which is at level "+ entry.getValue());     // Print the key with max value
            }
        }
	}
	
	private static List<BinaryTree> findLastLeafNode(BinaryTree root, List<BinaryTree> leafList) {
		
		if(root.left== null && root.right == null) leafList.add(root);
		
		if(root.left!=null) {  
			findLastLeafNode(root.left, leafList);
		}
		
		if(root.right != null) {
			findLastLeafNode(root.right, leafList);
		}
		
		return leafList;
	}

	static class BinaryTree {
		
		BinaryTree root;
		BinaryTree left;
		BinaryTree right;
		Integer data;
		Integer level;
		
		public BinaryTree(Integer data, Integer level) {
			this.data = data;
			this.level = level;
		}
		
		public BinaryTree(BinaryTree left, BinaryTree right, Integer data, Integer level) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.level = level;
		}
		
		public BinaryTree getRoot() {
			return root;
		}

		public void setRoot(BinaryTree root) {
			this.root = root;
		}

		public BinaryTree getLeft() {
			return left;
		}

		public void setLeft(BinaryTree left) {
			this.left = left;
		}

		public BinaryTree getRight() {
			return right;
		}

		public void setRight(BinaryTree right) {
			this.right = right;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}
	}	
}
