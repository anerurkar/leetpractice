package com.leetcode.exercises;

import java.util.Scanner;

/**
 * 
 * PLEASE NOTE THAT I DIDNT FOUND THE VERSIONCONTROL CLASS AND ITS METHOD isBasVersion(k)
 * Hence I have implemented it as per my understanding
 * 
 * First Bad Version - https://leetcode.com/problems/first-bad-version/ 
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version
 * is bad. Implement a function to find the first bad version. You should
 * minimize the number of calls to the API.
 * 
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 * Constraints: 1 <= bad <= n <= 231 - 1
 * 
 * 123456789
 * FFFFFFTTT
 * In above example, after 7 isBadVersion is returning true. Hence 7 is the answer
 */
public class FirstBadVersion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide the total number of Versions");
		int n = scan.nextInt();
		System.out.println("Please provide the Bad Version");
		int badVersions = scan.nextInt();
		scan.close();
		boolean[] versions = {false, false, false,true,true};
		System.out.println(firstBadVersionIterative(n));
	}
	
	/**Iterative SOlution*/
	public  static int firstBadVersionIterative(int n) {
	    for (int i = 1; i < n; i++) {
	        if (isBadVersion(i)) {
	            return i;
	        }
	    }
	    return n;
	}

	/**Binary Search Solution **/
	private static int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		
		while(start<end) {
			int mid = start+(end-start)/2;
			if(isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		
		if(isBadVersion(start)) return start;
		return -1;
		
	}

	private static boolean isBadVersion(int version) {
		boolean[] versions = {false, false, false,true,true};
		//Array counting starts from 0, hence a minus 1 is done
		return versions[version-1];
	}

}
