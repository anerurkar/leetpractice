package com.leetcode.exercises;

/**
 * 
 * Zalando Codility interview Question
 * 
 * https://leetcode.com/discuss/interview-question/1489612/phone-screen-paypay-japan
 * 
 * An array A consisting of N integers is given. The elements of array A together
 * represent a chain, and each element represents the strength of each link in
 * the chain. We want to divide this chain into three smaller chains. All we can
 * do is to break the chain in exactly two non-adjacent positions. More
 * precisely, we should break links P, Q (O < P < Q < N — 1, Q — P > 1),
 * resulting in three chains [O, P - 1], [P + 1, Q - 1] [Q + 1, N - 1]. The
 * total cost of this operation is equal to A[P] + A[Q] For example, consider
 * array A such that: { 5, 2, 4, 6, 3, 7 } We can choose to break the following
 * links: • 1,3 : total cost is 2+6=8 • 1,4 :total cost is 2+3=5 • 2,4: total
 * cost is 4+3=7 
 * returns the minimal cost of dividing chain into three pieces.
 * 
 * Input: {5, 2, 4, 6, 3, 7}
 * Output: 5
 */
public class MinimalCostOfDividingChain {

	public static void main(String[] args) {
		int[] array  = {5, 2, 4, 6, 3, 7};
		System.out.println(solve(array));
	}
	
	private static int solve(int[] array) {
	    int answer = Integer.MAX_VALUE;
	    for (int i = 3; i < array.length - 1; i++) {
	        for (int j = 1; j < i - 1; j++) {
	            if (array[i] + array[j] < answer) {
	                answer = array[i] + array[j];
	            }
	        }
	    }
	    return answer;
	}


}
