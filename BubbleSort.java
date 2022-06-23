package com.leetcode.exercises;

/**
 * Simple BubbleSort
 * 75. Sort Colors https://leetcode.com/problems/sort-colors/ Simplest
 *  
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent, with the
 * colors in the order red, white, and blue. We will use the integers 0, 1, and
 * 2 to represent the color red, white, and blue, respectively. You must solve
 * this problem without using the library's sort function.
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] input = {2,0,1};
		int numsSize = input.length;
		int[] output  =	bubbleSort(input,numsSize);
		
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]+",");
		}
		
	}

	private static int[] bubbleSort(int[] input, int numsSize) {
		
		for (int i = 1; i < numsSize - 1; i++) {
			for (int j = 0; j <= numsSize - 2; j++) {
				if (input[j] > input[j + 1]) {
					int tmp = input[j];
					input[j] = input[j+1];
					input[j+1] = tmp;
				}
			}
		}

		return input;
	}

	
}
