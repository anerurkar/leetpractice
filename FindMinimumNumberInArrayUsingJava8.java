package com.leetcode.exercises;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class FindMinimumNumberInArrayUsingJava8 {

	public static void main(String[] args) {
		
		int[] numbers = {4,1,13,90,16,2,0};
		int min = numbers[0];
		
		for(int i=1;i<numbers.length;i++) {
			if(min>=numbers[i]) {
				min = numbers[i];
			}
		}
		System.out.println("Minimum number is "+min);
		
		//Using Java 8 Find the minumum number in a Array
		int minimum = IntStream.of(numbers).min().getAsInt();
		System.out.println("Minimum number is "+minimum);
		int maximum = IntStream.of(numbers).max().getAsInt();
		System.out.println("Maximum number is "+maximum);
		IntStream.of(numbers).min();
		//IntStream.of(numbers).min().ifPresent(mini -> (System.out.println(mini)));
		IntStream.of(numbers).min().ifPresent(System.out::println);
		IntStream.of(numbers).min();
		IntStream.of(numbers).max();
		IntStream.of(numbers).average();
		IntStream.of(numbers).count();
		IntStream.of(numbers).sum();
		
		IntSummaryStatistics summaryStatistics = IntStream.of(numbers).summaryStatistics();
		int minim = summaryStatistics.getMin();
		int maxi = summaryStatistics.getMax();
		double avg = summaryStatistics.getAverage();		
		long sum = summaryStatistics.getSum();
		
		// Find 3 distinct small numbers from an array of int
		// Array: {4,1,13,90,16,2,0} Answer - 0,1,2
		//Clone the array so that the original Array is not disturbed and then work on this Copy
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		//Sort the array
		Arrays.sort(copy);
		//Pick first 3 
		for (int i = 0; i < 3; i++) {
			System.out.println(copy[i]);
			
		}
		
	}
	
	

}
