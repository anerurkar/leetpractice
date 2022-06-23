package com.leetcode.exercises;

import java.util.Scanner;

public class FindFactorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Integer inputNumber = Integer.parseInt(input);
		
		Integer factorial = findFactorial(inputNumber);
		System.out.println("Factorial of "+inputNumber+" is "+factorial);
	}

	private static Integer findFactorial(Integer inputNumber) {
		
		Integer fact = 1;
		for (int i = 1; i <= inputNumber; i++) {
			fact = fact *i;
		}
		
		return fact;
	}
}
