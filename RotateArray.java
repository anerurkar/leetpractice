package com.leetcode.exercises;

public class RotateArray {

	public static void main(String[] args) {
		
		int nums[] = {1,2,3,4,5,6,7}, k=3;
		nums = rotate(nums,k);
		System.out.println("Array after rotating it "+k+" times is ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		
		int nums1[] = {-1,-100,3,99}; 
		k=2;
		nums = rotate(nums1,k);
		System.out.println("Array after rotating it "+k+" times is ");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
	}
	
	public static int[] rotate(int[] nums, int k) {
	    // speed up the rotation
	    k %= nums.length;
	    int temp, previous;
	    for (int i = 0; i < k; i++) {
	      previous = nums[nums.length - 1];
	      for (int j = 0; j < nums.length; j++) {
	        temp = nums[j];
	        nums[j] = previous;
	        previous = temp;
	      }
	    }
	    return nums;
	  }

}
