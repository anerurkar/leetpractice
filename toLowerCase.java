package com.leetcode.exercises;

import java.util.Scanner;

/**
 * Leetcode 709: https://leetcode.com/problems/to-lower-case/
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * Input: s = "Hello"
 * Output: "hello"
 * Input: s = "here"
 * Output: "here"
 * Input: s = "LOVELY"
 * Output: "lovely"
 */
public class toLowerCase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(toLowerCase(input));
	}

	private static String toLowerCase(String input) {
		return input.toLowerCase();
	}

}
