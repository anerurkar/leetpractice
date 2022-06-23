package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Zalando Codility Interview Question
 * 
 * you are given a string consisting of digits. Find the biggest two-digits
 * value that is a consistent fragment of thr given string.
 * 
 * For example, two-digit consistent fragment of "50552"
 * are["50","05","55","52"], representing the numbers [50,5,55,52]. the biggest
 * value among them is 55.
 * 
 * Write a function :
 * 
 * class Solution { public int solution(String S); } that, given a string S
 * consisting of digits, returns the maximum two-digit value thst is a
 * consistent fragment of S
 *
 */
public class LargestTwoDigitSubsequenceSum {

	public static void main(String[] args) {
		String S = "50552";
		System.out.println(solution(S));
	}
	
	static int solution(String S) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < S.length() - 1; i++) {
			String sub = S.substring(i, i + 2);
			list.add(Integer.valueOf(sub));
			Collections.sort(list);
		}

		return list.get(list.size() - 1);
	}

}
