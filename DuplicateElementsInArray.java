package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Find duplicate numbers in a ArrayList 
 * Input: 55,4,25,25,7,8,8,47 
 * Output: 4 25
 */
public class DuplicateElementsInArray {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(55, 4, 25, 25, 7, 8, 8, 47);
		List<Integer> duplicateElements = findDuplicates(input);

		for (int i = 0; i < duplicateElements.size() - 1; i++) {
			System.out.println(duplicateElements.get(i));
		}
	}

	private static List<Integer> findDuplicates(List<Integer> input) {
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = 1; j < input.size(); j++) {
				if (input.get(i).equals(input.get(j))) {
					output.add(input.get(i));
					break;
				}
			}
		}
		return output;
	}
}
