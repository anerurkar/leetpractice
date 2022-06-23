package com.leetcode.exercises;

/**
 * 
 * Maximum Subarray https://leetcode.com/problems/maximum-subarray
 * Leetcode 53
 * 
 * Input1: {5,4,-1,7,8}
 * Output1 : 23
 * Input2: {-2,1,-3,4,-1,2,1,-5,4}
 * Output2 : 6
 * 
 * largestSumOfContiguousArray 23
 * largestSumOfContiguousArray 6
 */
public class LargestContiguousSubArray {

	public static void main(String[] args) {
		
		int[] nums = {5,4,-1,7,8};
		int largestSumOfContiguousArray = maxSubArrayBF(nums);
		System.out.println("largestSumOfContiguousArray "+largestSumOfContiguousArray);
		
		int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
		int largestSumOfContiguousArray1 = maxSubArray(nums1);
		System.out.println("largestSumOfContiguousArray "+largestSumOfContiguousArray1);
	}
	
	//Brute Force method O(n square)
	public static int maxSubArrayBF(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        
        return maxSubarray;
    }

	// Optimized solution O(N)
	public static int maxSubArray(int[] nums) {
		// Initialize our variables using the first element.
		int currentSubarray = nums[0];
		int maxSubarray = nums[0];

		// Start with the 2nd element since we already used the first one.
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			// If current_subarray is negative, throw it away. Otherwise, keep adding to it.
			currentSubarray = Math.max(num, currentSubarray + num);
			maxSubarray = Math.max(maxSubarray, currentSubarray);
		}

		return maxSubarray;
	}

}
