package com.leetcode.exercises;

/**
 * 
 * Given an array of weights and a target weight find if the array contains two values that are equal to the target weight.
 * eg: [1 2 5 6 9], Target 10 : true
 */
public class RandomPickwithWeight {

	public static void main(String[] args) {
		
		int[] w = {1,2,5,6,9};
		int target = 10;
		
		boolean isWeightEqualToTarget =  isWeightEqualToTarget(w,target);
		System.out.println("Is the sum of any 2 weights of array equal to the target "+target+" "+isWeightEqualToTarget);

	}

	private static boolean isWeightEqualToTarget(int[] w, int target) {
		
		boolean isWeightEqualToTarget = false;
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				if((w[i]+w[j])==target)
					isWeightEqualToTarget = true;
			}
		}
		
		return isWeightEqualToTarget;
	}
	
	

}
