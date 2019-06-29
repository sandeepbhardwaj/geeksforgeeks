package com.leetcode;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
public class RemoveDuplicates {
	public String removeDuplicates(String S) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);

			if (!stack.isEmpty() && stack.peek() == ch) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}

		StringBuffer result = new StringBuffer();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.reverse().toString();
	}
}