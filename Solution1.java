package com.leetcode.exercises;

public class Solution1 {
    public static void main(String[] args) {
		int greatest = 0;
		String num = ("50552");
		int max = -1;
		for (int n = 0; n < num.length() - 4; n++) {
			greatest = ((num.charAt(n) - '0') * 10000 + (num.charAt(n + 1) - '0') * 1000
					+ (num.charAt(n + 2) - '0') * 100 + (num.charAt(n + 3) - '0') * 10 + (num.charAt(n + 4) - '0'));
			if (max < greatest) {
				max = greatest;
			}
		}
		System.out.print(max);
    }
}

