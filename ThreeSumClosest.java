package com.leetcode.exercises;

import java.util.Arrays;

/**
 * 16. 3Sum Closest https://leetcode.com/problems/3sum-closest/
 * 
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * 
 * 
 * 
 * 
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		
		int[] nums = {-1,2,1,-4};
		int target = 1;
		
		System.out.println(threeSumClosest(nums, target));
	}

	private static int threeSumClosest(int[] nums, int target) {
		
		int closestSum = nums[0]+nums[1]+nums[nums.length -1];
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-1; i++) {
			int left = i+1;
			int right = nums.length-1;
			
			while(left<right) {
				int curSum = nums[i]+nums[left]+nums[right];
				if(Math.abs((target-curSum)) < Math.abs((target-closestSum))) {
					closestSum = curSum;					
				}
				if(curSum == target) return target;
				if(curSum > target) {
					right--;					
				} else {
					left++;
				}
			}
		}
		return closestSum;
	}

}
