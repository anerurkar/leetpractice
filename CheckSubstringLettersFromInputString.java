package com.leetcode.exercises;

/**
 * Visa Bangalore Interview Question
 * 
 * From a given String s = "The quick fox jumps over the lazy dog"
 * Check whether the each letter of Substring "visa" exists in the main String
 * 
 * Input: 
 * String text = "The quick fox jumps over the lazy dog";
 * String note = "visa";
 * Output: true		
 *
 * If Input String is changed to 
 * String text = "The quick fox jumps over the lazy dog";
 * String note = "visab";
 * Output: false
 * because b is not present in main String
 * 
 */
public class CheckSubstringLettersFromInputString {

	public static void main(String[] args) {
		String text = "The quick fox jumps over the lazy dog";
		String note = "visab";

		System.out.println(checkSubString(text, note));
	}

	private static Boolean checkSubString(String text, String note) {
		if (null != text && null != note) {
			String text1 = text.replaceAll("[^a-zA-Z]", " ");
			String note1 = note.replaceAll("[^a-zA-Z]", " ");
			//System.out.println(text1);
			for (Character ch1 : note1.toCharArray()) {
				if (text1.contains(ch1.toString())) {
					continue;
				}
				return false;
			}
			return true;
		}
		return true;
	}
}
