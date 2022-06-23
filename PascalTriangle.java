package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://algorithms.tutorialhorizon.com/pascal-triangle/
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 */
public class PascalTriangle {
	
	public static List<List<Integer>> generate(int numRows){
		
		/*List<List<Integer>> all_rows = new ArrayList<List<Integer>>();
		List<Integer> rows = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			rows.add(0,1);
			
			//Execute just one line for this inner For Loop
			for (int j = 1; j < rows.size()-1; j++) 
				rows.set(j,rows.get(j)+rows.get(j+1));
				
				all_rows.add(new ArrayList<Integer>(rows));
		}
			return all_rows;
		}*/
		
		
		List<List<Integer>> all_rows = new ArrayList<List<Integer>>(); //result
        List<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++) {
            row.add(0, 1); //add element 1 at index 0.

            //now iterate the row, keep adding elements in pair, starting from j=1,
            // and set the sum at index j
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));

            //create a copy of row and store it in all_rows
            all_rows.add(new ArrayList<Integer>(row));
        }
        return all_rows;
	}

	public static void main(String[] args) {
		int numRows = 10;
		List<List<Integer>> pascalTriangle = generate(numRows);	
		for (int i = 0; i <pascalTriangle.size() ; i++) {
            List<Integer> current = pascalTriangle.get(i);
            System.out.println(Arrays.toString(current.toArray()));
        }

	}
	
	

}
