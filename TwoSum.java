package com.leetcode.exercises;

/**
 * 1. Two Sum https://leetcode.com/problems/two-sum/
 * 3 input parameters x[int],y[int],target 
 * print 2 indices on output such that 1 element from x and 1 element from y will sub up to target
 * Input: x[] = {1,2,3}, y[] = {4,5,6}, targetSum = 8
 * Output: x[1], y[2] and x[2] and y[1]
 * 
 */
public class TwoSum {

	public static void main(String[] args) {

			int[] x = {1,2,3};
			int[] y = {4,5,6};
			int target = 8;
			
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < y.length; j++) {
					if(x[i]+y[j] == target)
						System.out.println(i+" "+j); 
				}
			}
			
		}

}
