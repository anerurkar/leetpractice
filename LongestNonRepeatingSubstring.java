package com.leetcode.exercises;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.
 * Exebeam Pune Interview Question
 * Find the longest non-repeating substring within a string.
 * Input: abcabcbb, bbbbb, pwwkew
 * Output: 3, 1, 3
 *
 */
public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {

		String s1 = "abcabcbb", s2 = "bbbbb", s3 = "pwwkew";
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s1));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s2));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s3));
	}

	public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

}
