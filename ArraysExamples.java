package com.leetcode.exercises;

import java.util.Arrays;

public class ArraysExamples {

	public static void main(String[] args) {
		String[] charArray  = {"abc","def","ghi"};
		
		for(String str:charArray) {
			System.out.println(str);
		}
		
		int marks[] = { 25, 35, 45, 55};
		
		System.out.println(marks);
		System.out.println(Arrays.toString(marks));
		
		int[][] matrix2D = { { 1, 2, 3 }, { 4, 5, 6 }};  
		//Printing a 2D array
		System.out.println(Arrays.deepToString(matrix2D));
		//Printing a 1D array from within a 2D Array incorrect way
		System.out.println(matrix2D[0]);
		//Printing a 1D array from within a 2D Array correct way
		System.out.println(Arrays.toString(matrix2D[0]));
		System.out.println(Arrays.toString(matrix2D[1]));
		
		//Comparing 2 Arrays
		int[] numbers1 = {1,2,3};
		int[] numbers2 = {4,2,3};
		System.out.println(Arrays.equals(numbers1, numbers2)); // false
		
		//varargs example
		System.out.println("Sum calculation using varargs "+sum(1,4,5));
		
	}

	
	private static int sum(int... numbers) {
			int sum=0;
			for(int number: numbers) {
				sum+=number;
			}
			return sum;
		}
}
