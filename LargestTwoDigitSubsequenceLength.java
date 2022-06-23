package com.leetcode.exercises;

//Java program for the above approach
class LargestTwoDigitSubsequenceLength {

//Function to find the length of the
//largest subsequence consisting of
//a pair of alternating digits
	static void largestSubsequence(char[] s) {
		// Variable initialization
		int maxi = 0;
		char prev1;

		// Nested loops for iteration
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// Check if i is not equal to j
				if (i != j) {

					// Initialize length as 0
					int len = 0;
					prev1 = (char) (j + '0');

					// Iterate from 0 till the
					// size of the String
					for (int k = 0; k < s.length; k++) {
						if (s[k] == i + '0' && prev1 == j + '0') {
							prev1 = s[k];

							// Increment length
							len++;
						} else if (s[k] == j + '0' && prev1 == i + '0') {
							prev1 = s[k];

							// Increment length
							len++;
						}
					}

					// Update maxi
					maxi = Math.max(len, maxi);
				}
			}
		}

		// Check if maxi is not equal to
		// 1 the print it otherwise print 0
		if (maxi != 1)
			System.out.print(maxi + "\n");
		else
			System.out.print(0 + "\n");
	}

//Driver Code
	public static void main(String[] args) {
		// Given String
		String s = "50552";
		Integer i = Integer.MAX_VALUE;
		System.out.println(i);

		// Function call
		largestSubsequence(s.toCharArray());
	}
}
