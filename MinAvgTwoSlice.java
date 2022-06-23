package com.leetcode.exercises;

/**
 * Codility Problem : Min-Avg-Two-Slice
 * An array A consisting of N integers is given. The elements of array A togethe represent a chain, 
 * and each element represents the strength of each link in the chain. 
 * We want to divide this chain into three smaller chains. 
 * All we can do is to break the chain in exactly two non-adjacent positions. More precisely, we should break links P, Q (O < P < Q < N — 1, Q — P > 1), resulting in three chains [O, P - 1], [P + 1, Q - 1] [Q + 1, N - 1]. The total cost of this operation is equal to A[P] + A[Q]
 * For example, consider array A such that: { 5, 2, 4, 6, 3, 7 }
 * We can choose to break the following links:
 * • 1,3 : total cost is 2+6=8
 * • 1,4 :total cost is 2+3=5
 * • 2,4: total cost is 4+3=7
 * returns the minimal cost of dividing chain into three pieces.
 * 
 * https://stackoverflow.com/questions/21635397/min-average-two-slice-codility
 * 
 * https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
 * Hi Sheng, brilliant deduction on the slice sizes.
 * Here’s a solution in Java using prefix-sums as expected by the cordiality test
 *
 */
class MinAvgTwoSlice {
	
	public static void main(String[] args) {
		
	}
	
    public int solution(int[] A) {
        int[] sum = new int[A.length + 1];
        // We store the prefix sums here, please note prefix sum arrays start with 0 so their size is A.length + 1;
        sum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        int result = 0;
        double best = 10000;
        for (int i = 0; i < A.length - 2; i++) {
            // Try pair
            double average = 1.0d * (sum[i + 2] - sum[i]) / 2;
            if (average < best) {
                best = average;
                result = i;
            }
            // Try triade
            average = 1.0d * (sum[i + 3] - sum[i]) / 3;
            if (average < best) {
                best = average;
                result = i;
            }
        }
        // Last pair
        double average = 1.0d * (sum[A.length] - sum[A.length - 2]) / 2;
        if (average < best) {
            result = A.length - 2;
        }
        return result;
    }
}
