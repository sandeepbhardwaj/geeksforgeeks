package com.koko.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()" Output: true Example 2:
 * <p>
 * Input: "()[]{}" Output: true Example 3:
 * <p>
 * Input: "(]" Output: false
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}