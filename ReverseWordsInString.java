package com.leetcode.exercises;

import java.util.Scanner;
/**
 * input = This is a Hello World Program
 * output = Program World Hello a is This
 *
 */
public class ReverseWordsInString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String output = reverseWordsInString(input);
		System.out.println(output);
	}

	private static String reverseWordsInString(String input) {
		String output = "";
		String splitArray[] = input.split(" "); // we have taken Space for splitting the words
		for(int i = splitArray.length-1;i>=0;i--) {
			output+= splitArray[i] + " ";
		}
		
		return output;
	}

}
