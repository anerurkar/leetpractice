package com.leetcode.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BalanceBracketsLeetCodeSolution {

	public static void main(String[] args) {
		String i1 = "()", i2 = "()[]{}", i3 = "(]", i4 = ")(", i5 = "([)]";
		String i6 = "{[]}", i7 = ")", i8 = "([]", i9 = "{", i10 = "([)])", i11 = "(((((((((())))))))))", i12 = "";
		/*
		 * String input = "()[]{}"; String input1 = "([{}])"; String input2 = "([{}])";
		 * String input3 = "([{}])";
		 */
		final char openParanthesis = '(';
		char closingParenthesis = ')';
		char openSB = '[';
		char closeSB = ']';
		char openFB = '{';
		char closeFB = '}';
		
		String isValidString =  minRemoveToMakeValid(i8);
		System.out.println(i1+" isValidString : "+ isValidString);
	}
	
    public static String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}