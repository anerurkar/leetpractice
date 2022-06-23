package com.leetcode.exercises;

import java.util.Arrays;

public class DuplicateElementinArray {

	public static void main(String[] args) {
		
		int[] nums = {1,1,1,3,3,4,3,2,4,2}; // {1,2,3,1} {1,2,3,4}  {1,1,1,3,3,4,3,2,4,2}
		boolean isDuplicatePresent = duplicateElement(nums);
		System.out.println(isDuplicatePresent);
	}
	
	public static boolean duplicateElement(int[] nums) {
		//Sort the array
		Arrays.sort(nums);
		//Loop through it & compare adjacent elements
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==nums[i+1]) {
				return true;
			}
		}
		return false;
	}

}
