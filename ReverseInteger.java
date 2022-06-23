package com.leetcode.exercises;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/reverse-integer/solution/
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Input: x = 123
 * Output: 321
 * Input: x = -123
 * Output: -321
 * Input: x = 120
 * Output: 21
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		scan.close();
		System.out.println(reverseInteger(i));
	}

	private static int reverseInteger(int x) {
		int output = 0;
		boolean negative = false;
		if(x<0) {
			x = x*-1;
			negative = true;
		}
		
		while (x > 0) {
			output = 10 * output + (x % 10);
			x = x / 10;
		}
		
		if(output > Integer.MAX_VALUE) return 0;
		if(negative) {
			return (int) output*-1;
		}
		return output;
		
	}

}
