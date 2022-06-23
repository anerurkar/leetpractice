package com.leetcode.exercises;

/**
 * 
 * Print all the possible String permutations
 */
public class PrintStringPermutaions {
	
	/**
	 * Function to Swap the characters at the given positions
	 */
	private static String swapChars(String input,int pos1,int pos2) {
		char temp = 0; // temporary variable used for swapping
		char[] charArray = input.toCharArray();
		// Now we will fo the swapping
		temp = charArray[pos1];
		charArray[pos1] = charArray[pos2];
		charArray[pos2] = temp;
		return String.valueOf(charArray);
	}
	
	/*
	 * Recursive function to generate the permutations of String
	 */
	private static void recursiveSwapping(String input,int left,int right) {
		
		//breakpoint condition
		if(left==right) {
			System.out.println(input);
		} else {
			// Nowlop through the String from left position to right position each char at a time
			for (int i = left; i <= right; i++) {
				// Pick the first character and start replacing it with rest of the characters
				String swappedString = swapChars(input,left,i);
				//Now call the function recursively for the remaining characters 
				recursiveSwapping(swappedString,left+1,right);
			}
		}
	}
	
	//main function
	public static void main(String[] args) {
		String input = "ABCD";
		recursiveSwapping(input,0,input.length()-1);
	}
	
}
