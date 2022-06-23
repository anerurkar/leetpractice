package com.leetcode.exercises;

/**
 * 
 * Input : int a=1, n=2
 * Output=12;
 * Calc: 1+11 =12;
 * 
 * Input : int a=2, n=3
 * Output=246;
 * Calc: 2+22+222 =246;
 * 
 * Input : int a=5, n=3
 * Output=246;
 * Calc: 5+55+555 = 615
 * 
 * Input : int a=5, n=5
 * Output=246;
 * Calc: 5+55+555+5555+55555 = 61,725
 */
public class ConcentrixProgram {
	
	public static void main(String[] args) {
		
		int a=2, n=3;
		int output = calc(a,n);
		System.out.println(output);
	}

	/**
	 * 
	 * @param a
	 * @param n
	 * @return 12
	 * 1+11 =12;
	 * 2+22+222 =246;
	 * 5+55+555 = 615
	 * 5+55+555 = 615
	 */
	private static int calc(int a, int n) {
		
		int addingValue = a,b=a, exp=1;
		int sum = 0, j = 1;
		
		for (int i = 1; i <= n; i++) {
			 sum = sum *10 + 1;
	         
			//exp = (int) Math. pow(a, i);
			addingValue += sum;
		}
		
		
		return addingValue;
		
	}
}
