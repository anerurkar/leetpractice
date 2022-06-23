package com.leetcode.exercises;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-common-subsequence/ Given two strings
 * text1 and text2, return the length of their longest common subsequence. If
 * there is no common subsequence, return 0. A subsequence of a string is a new
 * string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters. For
 * example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 *
 * Output:
 * subsequenceLength is 3
 * subsequenceLength is 4
 * subsequenceLength is 0
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "abcde", s2 = "ace", s3 = "agbecfd", s4 = "abcd", s5 = "abc", s6 = "def";
		int subsequenceLength1 = longestCommonSubsequence(s1, s2);
		System.out.println("subsequenceLength is " + subsequenceLength1);
		int subsequenceLength2 = longestCommonSubsequence(s3, s4);
		System.out.println("subsequenceLength is " + subsequenceLength2);
		int subsequenceLength3 = longestCommonSubsequence(s5, s6);
		System.out.println("subsequenceLength is " + subsequenceLength3);
		
		//2nd Method
		System.out.println("************************************");
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s1));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s2));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s3));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s4));
		System.out.println("Length of Longest Substring is "+lengthOfLongestSubstring(s5));

	}

	public static int longestCommonSubsequence(String s1, String s2) {
		if (s1.equals(s2))
			return s1.length();
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int size1 = s1.length(), size2 = s2.length();
		
		for (int i = 1; i <= size1; i++) {
			for (int j = 1; j <= size2; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+ dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
					
			}
			
		}
		return dp[size1][size2];
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
