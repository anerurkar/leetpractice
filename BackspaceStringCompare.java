package com.leetcode.exercises;

import java.util.Scanner;
import java.util.Stack;

/**
 * Leetcode 844: https://leetcode.com/problems/backspace-string-compare/ 
 * Given two strings s and t, return true if they are equal when both are typed into
 * empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * 
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * 
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * 
 *  Constraints:
 *  1 <= s.length, t.length <= 200
 *  s and t only contain lowercase letters and '#' characters.
 *  Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide first Input String");
		String inputString1 = scan.nextLine();
		System.out.println("Please provide first Input String");
		String inputString2 = scan.nextLine();
		scan.close();
		System.out.println("The comparison is "+backSpaceCompare(inputString1,inputString2));
	}

	private static boolean backSpaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}
	
	 public static String build(String S) {
	        Stack<Character> ans = new Stack();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }

}
