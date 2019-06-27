package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 */
public class ValidParentheses {
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			// for open parentheses push to stack
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			char top = stack.pop();

			if (ch == ')' && top != '(') {
				return false;
			}

			if (ch == '}' && top != '{') {
				return false;
			}

			if (ch == ']' && top != '[') {
				return false;
			}
		}

		return stack.isEmpty();
	}
}