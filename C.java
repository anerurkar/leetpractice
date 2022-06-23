package com.leetcode.exercises;

public class C extends A{
	
	public C(B b) {
		super(b);
	}
	
	/*
	 * a and b < INTEGER.MAX  
	 * a and b should be 
	 * 
	 * 0 
	 */
	public static double multiply(long a, long b) {
		
		if(a<=Long.MAX_VALUE && b<=Long.MAX_VALUE) {
			double c = a * b;
			return c;
		}
		
		return 0;
		
	}
	
	

}
