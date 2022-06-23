package com.leetcode.exercises;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinimumNumberInArray {

	public static void main(String[] args) {
		
		int[] numbers = {4,1,3,90,16,2,0};
		int min = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
			if(min>numbers[i]) {
				min = numbers[i];				
			}
		}
		System.out.println("Minimum is "+min);
		
		IntStream.of(numbers).min().ifPresent(System.out::println);
		IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
		statistics.getAverage();
		statistics.getCount();
		statistics.getMax();
		statistics.getMin();
		statistics.getSum();
		
		//System.out.println(min1);
		
		
	}
	
	
	

}
