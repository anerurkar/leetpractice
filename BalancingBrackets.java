package com.leetcode.exercises;

import java.util.Iterator;
import java.util.Stack;

public class BalancingBrackets {

	/**
	 * 1. "()" -> true
	2. "()[]{}" -> true
	3. "(]" -> false
	4. ")(" -> false
	5. "([)]" -> false
	6. "{[]}" -> true
	7. ")" -> false
	8. "([]" -> false
	9. "{" -> false
	10. "([)])" -> false
	11. "(((((((((())))))))))" -> true
12. "" -> true
	 * @param args
	 */
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
		
		for (int i = 1; i <= 12; i++) {
			//System.out.println("i"+i);
			String str = "i"+i;
			System.out.println(isStringValid(str));
			//System.out.println("Is i"+i+" String valid: "+isStringValid("i"+i));
		}
		Boolean isValidString =  isStringValid(i4);
		System.out.println(i4+" isValidString : "+ isValidString);
		
	}

	private static Boolean isStringValid(String input) {
		
		char[] ch = input.toCharArray();
		Stack<Character> myStack = new Stack<Character>();
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{')
				myStack.push(ch[i]);
			if(ch[i] == ')' || ch[i] == ']' || ch[i] == '}') {
				char c1 = myStack.pop();
				if((c1 == '(' && ch[i] == ')') || (c1 == '[' && ch[i] == ']') || (c1 == '{' && ch[i] == '}' )) {
					return true;
				}else
					return false;
					
			}
				
		}
		
		/*for (Iterator iterator = myStack.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			
			if(iterator.next().equals('(') && iterator.)
			
		}*/
		
		for (int i = 0; i < ch.length; i++) {
			if(myStack.pop().equals('(') && myStack.pop().equals(')')) {
				return true;
			}else 
				return false;
		} 
		
		for (Iterator iterator = myStack.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			
		}
		
		for (char val : ch) {
			
			if(val == '(') {
				
			} else if(val == '[') {
				
			} else if(val == '{') {
				
			} 
		}
		
		
		return null;
	}

}
