package com.leetcode.exercises;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 * 
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. 
 * Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. 
 * Therefore it is not a palindrome.
 * 
 * Constraints:
 * -231 <= x <= 231 - 1
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 * 
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println("Please enter the input number ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		System.out.println(input+" is a Palindrome: "+isPalindrome(input));
		
	}

	public static boolean isPalindrome(int x) {
		
		if(x<0 || (x!=0 && x%10==0)){
			return false;
		}
		
		int num = x, reverseNum=0;
		while(num!=0) {
			int remainder = num%10; // Take the remainder and add it to reverseNum
			num = num/10; // Remove last digit
			reverseNum = reverseNum*10+remainder; // Create reverseNum by adding remainder 
		}
		if(x == reverseNum)
			return true;
		else
			return false;
    }

}
