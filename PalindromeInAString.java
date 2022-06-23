package com.leetcode.exercises;

public class PalindromeInAString {
	
	/**
	 * Leetcode 125 - https://leetcode.com/problems/valid-palindrome/
	 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters 
	 * and ignoring cases.
	 */
	public static boolean isPalindrome(String s) {
		
		StringBuilder builder = new StringBuilder();
		
		for(char ch : s.toCharArray()) {
			if(Character.isLetterOrDigit(ch)) {
				builder.append(Character.toLowerCase(ch));
			}
		}
		
		String filteredString = builder.toString();
		String reversedString = builder.reverse().toString();
		
		return filteredString.equals(reversedString);
	}
	
	/**
	 * Am alternate Solution is using Java 8 Streams
	 * 
	 */
	public static boolean isPalindromeUsingStreams(String s){
		
		StringBuilder builder = new StringBuilder();
		
		s.chars()
			.filter(c -> Character.isLetterOrDigit(c))
			.mapToObj(builder::append)
			.forEach(builder::append);
		
		return builder.toString().equals(builder.reverse().toString());
	}
	

	public static void main(String[] args) {
		
		String input1 = "A man, a plan, a canal: Panama";
		String input2 = "race a car";
		
		System.out.println("The String "+input1+" is Palindrome is: "+ isPalindrome(input1));
		System.out.println("The String "+input2+" is Palindrome is: "+ isPalindromeUsingStreams(input2));
	}

}
