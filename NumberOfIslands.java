package com.leetcode.exercises;

/**
 * Leetcode: 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/ 
 * Given an m x n 2D binary
 * grid grid which represents a map of '1's (land) and '0's (water), return the
 * number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * Example 1:
 * Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
 ]
 * Output: 1
 * 
 * Example 2:
 * Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 * 
 */
public class NumberOfIslands {

	public static void main(String[] args) {

	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int count = 0;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '1') {
					count++;
					helper(grid, r, c);
				}
			}
		}
		return count;
	}

	private static void helper(char[][] grid, int r, int c) {
		// The below condition is used to check as follows:
		// r<0 or c<0 -> This will check all the rows & columns which are outside of the grid 
		// to the left side. 
		// c>= grid[0].length checks whether we are not going outside from the grid on rightside of the grid
		// grid[r][c] == '0' is done to check that we dont encounter a 0 at the position
		// In all these cases we just come out and dont process
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
			return;
		
		// grid[r][c] = '0'; is done so that once we encounter a 1 the counter is incremented and after that we make
		// that position as 0, so that we dont repeat getting 1 in that place
		grid[r][c] = '0';
		helper(grid, r + 1, c);
		helper(grid, r - 1, c);
		helper(grid, r, c + 1);
		helper(grid, r, c - 1);
	}

}
