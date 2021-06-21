package com.leetcode.stack;

import java.util.Stack;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any
 * positions ) so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * Example 1:
 * Input: s = "())"
 * Output: 1
 * <p>
 * Example 2:
 * Input: s = "((("
 * Output: 3
 * <p>
 * Example 3:
 * Input: s = "()"
 * Output: 0
 * <p>
 * Example 4:
 * Input: s = "()))(("
 * Output: 4
 */
public class MakeParenthesesValid {
	public static int minAddToMakeValid(String s) {
		int invalid = 0;
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty() && c == ')') {
				invalid++;
				continue;
			}

			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				if (c == '(')
					stack.push(')');
				else
					stack.push('(');
			}
		}
		return invalid + stack.size();
	}

	public static void main(String[] args) {
		String s = "()))((";
		System.out.println(minAddToMakeValid(s));
	}
}

