package com.leetcode.exercises;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7] 
 * Output: 49 
 * Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 * Constraints:
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * 
 * Approach 1 using 2 Loops
 * Time Complexity is O(N^2)
 * Space Complexity is O(1)
 * 
 * Approach2
 * 
 * 
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		
		int[] height1 = {1,8,6,2,5,4,8,3,7};
		int[] height2 = {1,8,6,2,5,4,8,3,7};
		int maxArea1 = maxAreaApproach1(height1);
		int maxArea2 = maxAreaApproach1(height2);
		
	}

	private static int maxAreaApproach1(int[] height) {
		//1. Initialize max to zero
		int max = 0;
		//2. A for loop for the left pointer
		for (int i = 0; i < height.length; i++) {
			//3. A for loop for the right pointer
			for (int j = i+1; j < height.length; j++) {
				int currentAera = Math.min(height[i], height[j]) * (j-i);
				//4. Update maximum area
				max = Math.max(max, currentAera);
			}
		}
		//5. Return the maximum area
		return max;
	}
}
