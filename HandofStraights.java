package com.leetcode.exercises;

import java.util.PriorityQueue;

/**
 * @author sikandarmshaikh https://leetcode.com/problems/hand-of-straights/ 
 * 846.Hand of Straights 
 * Alice has some number of cards and she wants to
 * rearrange the cards into groups so that each group is of size
 * groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the
 * ith card and an integer groupSize, return true if she can rearrange
 * the cards, or false otherwise.
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * The given number can be grouped in size of 3 is true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * The given number can be grouped in size of 4 is false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 * 
 * Logic: First Sort the given number. The use a Priority Queue to push the numbers one by one in consecutive manner
 * in the mentioned groupSize. If after popping up the queue for all numbers for a groupSize if still the queue is not 
 * empty then return false otherwise return true
 *
 */
public class HandofStraights {

	public static void main(String[] args) {
		int[] hand = {1,2,3,4,5};
		int W = 4;
		System.out.println("The given number can be grouped in size of "+W+" is "+isNStraightHand(hand, W));
	}

	private static boolean isNStraightHand(int[] hand, int W) {
		//Use PriorityQueue as it sorts the elements by default while inserting
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//Add all the numbers in the array into the Queue
		for(int i: hand) { pq.add(i);}
		
		//Loop through the Queue and check if it is not empty to poll the head of the queue
		// and then check the next elements one by one in the for loop
		while(!pq.isEmpty()) {
			int cur = pq.poll(); // poll returns & removes the head of the Queue i.e., first element of the Queue
			//Since we need to group the numbers as per the groupSize "W"
			// We can loop W and try to remove the numbers from the queue one by one
			// If we are not successful in removing then we can return false otherwise return true
			for(int i=1; i< W; i++) {
				if(!pq.remove(cur+i)) return false;
			 }
		}
		return true;
	}

}
