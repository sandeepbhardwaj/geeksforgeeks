package com.koko.string;

import java.util.Stack;

/**
 * Bomber Algo: The bomber algorithm doesn't like consecutive characters in a
 * given string to be same. For Example: If the given string is abcccbd the
 * bomber algo will first bomb ccc and then bb, so the final output string will
 * become ad. The bomber algo will destroy the characters only if there are more
 * than 1 continuous occurrence of same characters in the string.
 * <p>
 * Write a code of the bomber algo. The method takes a string as an input and
 * returns the bombed string as an output.
 * <p>
 * If you are taking any assumptions, please do mention them before the code!
 * <p>
 * Examples:
 * <p>
 * Input 1: aabcccdee
 * Output: bd
 * Explanation
 * Step 1: aabcccdee
 * Step 2: bcccdee
 * Step 2: bdee
 * Step 3: bd (Final Answer)
 * <p>
 * Input 2: abcdeedcbfgf
 * Output : afgf
 * Explanation
 * Step 1: eeabcddcbfgf
 * Step 2: abcddcbfgf
 * Step 3: abccbfgf
 * Step 4: abbfgf
 * Step 5: afgf (Final Answer)
 * <p>
 * Input 3: abbabba
 * Output: a
 * Explanation
 * Step 1: aabba
 * Step 2: bba
 * Step 3: a (Final Answer)
 */

public class BombedStringExample {

	public static String removeAdjacentDuplicates(String s) {
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
		String str = "abcdeedcbfgf"; //
		System.out.println(removeAdjacentDuplicates(str));
	}

}
