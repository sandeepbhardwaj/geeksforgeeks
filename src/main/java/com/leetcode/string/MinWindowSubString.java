package com.leetcode.string;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * <p>
 * Example: Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * <p>
 * Note: If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 *
 * @author sandeep
 */
public class MinWindowSubString {

	/**
	 * decrement map counter for end, increment map counter for start decrement
	 * count for end if element from pattern found, increment count for start if
	 * element from pattern found.
	 *
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static String minWindow(String str, String pattern) {
		int[] map = new int[128];

		// populate map for patterns string
		for (char c : pattern.toCharArray()) {
			// increments the element at index c
			map[c]++;
		}
		int left = 0, right = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = pattern.length();

		// using two pointer approach left and right for sliding window
		while (right < str.length()) {
			//get the char and increment the window size
			final char c1 = str.charAt(right++);

			// if pattern element found in string the decrement counter
			if (map[c1] > 0) {
				counter--;
			}
			// decrement the element at index c1
			map[c1]--;

			// if all element of pattern found
			while (counter == 0) {

				// if min len found change it to new minLen and minStart
				if (minLen > right - left) {
					minLen = right - left;
					minStart = left;
				}
				final char c2 = str.charAt(left);
				// increment count in map, before shrinking the window size
				map[c2]++;

				// if ignored element is from pattern then increment counter
				if (map[c2] > 0) {
					counter++;
				}
				// increment start to make it invalid/valid again
				left++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		System.out.println("Min Window :" + minWindow("badaabcccdasfasabcd", "abd"));
	}

}
