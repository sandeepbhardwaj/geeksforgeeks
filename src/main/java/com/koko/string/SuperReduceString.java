package com.koko.string;

import java.util.Stack;

/**
 * Hacker Rank - SuperReduceString
 */
public class SuperReduceString {
	public static String superReducedString(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(superReducedString("aaabccddd"));
	}
}
