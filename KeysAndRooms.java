package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Logic: In this [[1],[2],[3],[]] we already have access to Room 0 from where we get Key of Room1
 * Now When we enter Room1 we get Keys for Room2 and so on we will visit the last empty space which is Room3
 * Hence we have visited all the Rooms and so we return true
 * In this [[1,3],[3,0,1],[2],[0]] we enter Room 1 and then we enter Room 3 in first array Value
 * Then in second Array Value we enter Room 1 and 3 again and so on as have Keys for both 1 & 3
 * But we never enter Room2 as we didnt had its Keys anytime. Hence this returns false
 * 
 * 841. Keys and Rooms https://leetcode.com/problems/keys-and-rooms/
 * 
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 *
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation: 
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * 
 * We will be using a Stack and Hashset for the Solution
 * First we check whether Stack is not empty then we go to the room and bring the Key
 * Initially Set will have 0 and then check whether the value in Stack and Key are same
 * If not then we add this Key to the Stack otherwise if they are same then we remove the Key fromStack
 * If the Set(of Keys) is less than the rooms Size then still some rooms are there which we didnt visit
 * Hence it will return false 
 * 
 * Example 2:
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 * Constraints:
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 * 
 * Program Output:
 * All elements in the Rooms are 
 * [ 1, ][ 2, ][ 3, ][  ]
 * All rooms are visited : true
 * All elements in the Rooms are 
 * [ 1,3, ][ 3,0,1, ][ 2, ][ 0, ]
 * All rooms are visited : false
 */
public class KeysAndRooms {

	public static void main(String[] args) {
		
		//Create a Two dimentional ArrayList of Integers
		List<List<Integer>> rooms1 = create2DimentionalArrayList1();
		System.out.println("All elements in the Rooms are ");
		print2DimentionalArrayList(rooms1);
		System.out.println();
		System.out.println("All rooms are visited : "+canVisitAllRooms(rooms1));
		
		//Create a Two dimentional ArrayList of Integers
		List<List<Integer>> rooms2 = create2DimentionalArrayList2();
		System.out.println("All elements in the Rooms are ");
		print2DimentionalArrayList(rooms2);
		System.out.println();
		System.out.println("All rooms are visited : "+canVisitAllRooms(rooms2));
	}

	private static List<List<Integer>> create2DimentionalArrayList1() {
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(new ArrayList<>(Arrays.asList(1)));
		rooms.add(new ArrayList<>(Arrays.asList(2)));
		rooms.add(new ArrayList<>(Arrays.asList(3)));
		rooms.add(new ArrayList<>(Arrays.asList()));
		return rooms;
	}

	private static List<List<Integer>> create2DimentionalArrayList2() {
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(new ArrayList<>(Arrays.asList(1,3)));
		rooms.add(new ArrayList<>(Arrays.asList(3,0,1)));
		rooms.add(new ArrayList<>(Arrays.asList(2)));
		rooms.add(new ArrayList<>(Arrays.asList(0)));
		return rooms;
	}

	private static void print2DimentionalArrayList(List<List<Integer>> rooms) {
		//Print a Two dimentional ArrayList of Integers
		for (int i = 0; i < rooms.size(); i++) {
			System.out.print("[ ");
			for (int j = 0; j < rooms.get(i).size(); j++) {
				System.out.print(rooms.get(i).get(j)+",");
			}
			System.out.print(" ]");
		}
	}

	private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> set = new HashSet<>();
		
		Stack<Integer> stack = new Stack<>();
		//add 0 to stack as we have Key for 0
		stack.add(0);
		
		while(!stack.isEmpty()) {
			//first pop out the integer in the Stack and we put it in current Key
			int cur = stack.pop();
			//Now we bring in the current Key to check if the Stack doesnot contain current Key
			if(!set.contains(cur)) {
				//If the Key have never been obtained or the Room is never visited then we will process
				set.add(cur);
				//Now we check the Keys in the Rooms
				for(int x: rooms.get(cur)) {
					//When we open that Room we will find different Keys in there
					//We look these keys and check whether it is there in the Set
					//If not then we add it to the Stack
					if(!set.contains(x)) {
						stack.push(x);
					}
				}
			}
		}
		//The Size of the HashSet which denotes All the Keys we have will be compared to the Rooms size
		// This will give us how many Rooms we have Visited
		return set.size() == rooms.size();
	}

}
