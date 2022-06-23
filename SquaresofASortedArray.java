package com.leetcode.exercises;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * 
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * Output of Program:
 * Input Array is 
 * -4,-1,0,3,10,
 * Output Array is 
 * 0,1,9,16,100,
 * Input Array is 
 * -7,-3,2,3,11,
 * Output Array is 
 * 4,9,9,49,121,
 */
public class SquaresofASortedArray {

	public static void main(String[] args) {
		int[] nums1 = {-4,-1,0,3,10};
		System.out.println("Input Array is ");
		printArray(nums1);
		int[] result1 = sortedSquares(nums1);
		System.out.println();
		System.out.println("Output Array is ");
		printArray(result1);
		System.out.println();
		
		int[] nums2 = {-7,-3,2,3,11};
		System.out.println("Input Array is ");
		printArray(nums2);
		int[] result2 = sortedSquares(nums2);
		System.out.println();
		System.out.println("Output Array is ");
		printArray(result2);
		
	}

	private static void printArray(int[] result1) {
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i]+",");
		}
	}

	private static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i]*=A[i];
		}
		Arrays.sort(A);
		return A;
	}

}
