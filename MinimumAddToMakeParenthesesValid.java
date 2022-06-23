package com.leetcode.exercises;

import java.util.Scanner;
import java.util.Stack;

/**
 * Minimum Add to Make Parentheses Valid
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/ 
 * A parentheses string is valid if and only if:
 * It is the empty string, It can be written as AB (A concatenated with B),
 * where A and B are valid strings, or It can be written as (A), where A is a
 * valid string. You are given a parentheses string s. In one move, you can
 * insert a parenthesis at any position of the string.
 * 
 * For example, if s = "()))", you can insert an opening parenthesis to be
 * "(()))" or a closing parenthesis to be "())))". Return the minimum number of
 * moves required to make s valid
 * 
 * Input: s = "())"
 * Output: 1
 * Input: s = "((("
 * Output: 3
 * 
 */
public class MinimumAddToMakeParenthesesValid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(minAddToMakeValid(input));
		System.out.println(minAddToMakeValidUsingStack(input));
	}

	private static int minAddToMakeValidUsingStack(String S) {

		Stack<Character> stack = new Stack<>();

		for (char c : S.toCharArray()) {

			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(')');
				}

			}
		}
		return stack.size();
	}

	private static int minAddToMakeValid(String S) {
		int left = 0, right = 0;
		
		for(char ch: S.toCharArray()) {
			if(ch == ('(')) {
				left++;
			} else {
				if(left>0) {
					left--;
				} else {
					right++;
				}
			}
		}
		
		return left+right;
	}

}
