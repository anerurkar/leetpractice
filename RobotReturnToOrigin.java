package com.leetcode.exercises;

/**
 * Logic: Think that we have the Robot in a position where Horizontal and Vertical lines intersect
 * Now if we encounter U - Up, D- Down, L- Left and R - Right
 * We keep on incrementing horizontal if we encounter Right and decrement for Left
 * We keep on incrementing vertical if we encounter Up and decrement for Right
 * In the end we just check if both horizontal and Vertical are at 0, If Yes we return true
 * Other we return False
 * 
 * 657. Robot Return to Origin
 * https://leetcode.com/problems/robot-return-to-origin/ 
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence
 * of its moves, judge if this robot ends up at (0, 0) after it completes its
 * moves.
 * 
 * You are given a string moves that represents the move sequence of the robot
 * where moves[i] represents its ith move. Valid moves are 'R' (right), 'L'
 * (left), 'U' (up), and 'D' (down).
 * 
 * Return true if the robot returns to the origin after it finishes all of its
 * moves, or false otherwise.
 * 
 * Note: The way that the robot is "facing" is irrelevant. 'R' will always make
 * the robot move to the right once, 'L' will always make it move left, etc.
 * Also, assume that the magnitude of the robot's movement is the same for each
 * move.
 * Example 1:
 * Input: moves = "UD" 
 * Output: true
 * Explanation: The robot moves up once, and then down once. 
 * All moves have the same magnitude, so it ended up at the origin where it started. 
 * Therefore, we return true.
 * Example 2:
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 * Constraints:
 * 1 <= moves.length <= 2 * 104
 * moves only contains the characters 'U', 'D', 'L' and 'R'.
 * 
 *
 */
public class RobotReturnToOrigin {

	public static void main(String[] args) {
		String moves = "LL";
		boolean status = judgeCircle(moves);
		System.out.println("The Robot is in Original Position is "+status);
	}

	private static boolean judgeCircle(String moves) {
		int hor = 0, ver = 0;
		
		for(char c : moves.toCharArray()) {
			if(c == 'U') ver++;;
			if(c == 'D') ver--;
			if(c == 'L') hor++;
			if(c == 'R') hor--;
		}
		return hor ==0 && ver ==0;
	}

}
