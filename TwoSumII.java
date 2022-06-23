package com.leetcode.exercises;

public class TwoSumII {

/**
 * @author Sikandar
 * 
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
 * find two numbers such that they add up to a specific target number. 
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * 
 * 
 */
	
	/**
	 * 
	 * 
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
    public static int[] twoSum(int[] numbers, int target) {
        
    	int[] output = new int[2];
    	int start = 0;
    	int end = numbers.length-1;
    	while(start < end) {
    		int sum = numbers[start]+numbers[end];
    		if(sum == target) {
    			output[0] = start+1;
    			output[1] = end+1;
    			return output;
    		} else if(sum > target) {
    			end--;
    		} else {
    			start++;
    		}
    	}
    	return output;
    }
	
	
	public static void main(String[] args) {
		
		

	}

}
