package com.koko.stack;

import java.util.Stack;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
	public static String reverseParentheses(String s) {
		Stack<String> stack = new Stack<>();

		int i = 0;
		while (i < s.length()) {
			//push in stack till ) encounter
			if (s.charAt(i) != ')') {
				stack.push(s.charAt(i) + "");
			} else {
				// if ) found
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					sb.append(stack.pop());
				}
				stack.pop(); //remove last (
				stack.push(sb.reverse().toString());
			}
			i++;
		}

		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty())
			res.append(stack.pop());

		return res.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println("(u(love)i) : " + reverseParentheses("(u(love)i)"));
	}
}
