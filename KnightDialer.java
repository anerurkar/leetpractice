package com.leetcode.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/knight-dialer/
 * https://leetcode.com/problems/knight-dialer/discuss/1292870/Java-dp-solution
 * Given a phone pad as below. List out all the phone numbers that can be made with 7 digits. 
 * The method of generating the numbers would be the movement of a rook. 
 * It can move vertically and horizontally by any number of steps.
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * 
 *
 */
public class KnightDialer {

	static int MOD = 1000000007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Enter the number for which possible combinations of dialing can be done in the movement of a rook");
		int input = sc.nextInt();
		int output1 = knightDialer(input);
		int output2 = knightDialerSolution2(input);
		System.out.println("The number of moves that can be made are: " + output1 + "::::" + output2);
	}

	public static int knightDialer(int N) {
		long dp[] = new long[10];
		Arrays.fill(dp, 1);
		long ans = 0;
		for (int i = 1; i < N; i++) {
			long temp[] = new long[10];
			temp[0] = (dp[4] + dp[6]) % MOD;
			temp[1] = (dp[6] + dp[8]) % MOD;
			temp[2] = (dp[7] + dp[9]) % MOD;
			temp[3] = (dp[4] + dp[8]) % MOD;
			temp[4] = (((dp[0] + dp[3]) % MOD) + dp[9]) % MOD;
			temp[6] = (((dp[0] + dp[1]) % MOD) + dp[7]) % MOD;
			temp[7] = (dp[2] + dp[6]) % MOD;
			temp[8] = (dp[1] + dp[3]) % MOD;
			temp[9] = (dp[4] + dp[2]) % MOD;
			dp = temp;
		}
		for (long val : dp)
			ans = (ans + val) % MOD;
		return (int) ans;
	}

	public static int knightDialerSolution2(int n) {

		if (n == 1)
			return 9;

		// Total number of knight moves
		// Since 5 is in the middle, hence it doesnt have any knight moves
		int[][] branches = { 
							{ 1, 6 }, { 1, 8 }, 
							{ 2, 9 }, { 2, 7 }, 
							{ 3, 8 }, { 3, 4 }, 
							{ 4, 9 }, { 4, 3 }, 
							{ 6, 7 },{ 6, 1 }, 
							{ 7, 2 }, { 7, 6 }, 
							{ 8, 3 }, { 8, 1 }, 
							{ 9, 2 }, { 9, 4 } };

		long[] counts = new long[10];
		Arrays.fill(counts, 1);

		final int MOD = 1_000_000_007;
		for (int i = 1; i < n; i++) {
			long[] nextCounts = new long[10];
			for (int[] pair : branches) {
				nextCounts[pair[1]] = (nextCounts[pair[1]] + counts[pair[0]]) % MOD;
			}
			counts = nextCounts;
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (int) ((sum + counts[i]) % MOD);
		}

		return sum;
	}

}
