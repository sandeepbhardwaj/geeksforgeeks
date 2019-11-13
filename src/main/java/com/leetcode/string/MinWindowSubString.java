package com.leetcode.string;

/**
 * 76. Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example: Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 * 
 * 
 * @author sandeep
 *
 */
public class MinWindowSubString {

	public static void main(String[] args) {
		System.out.println("Min Widnow :" + minWindow("badaabcccdasfasabcd", "abd"));
	}

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
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = pattern.length();

		// using two pointer approach start and end for sliding window
		while (end < str.length()) {
			final char c1 = str.charAt(end);

			// if pattern element found in string the decrement counter
			if (map[c1] > 0) {
				counter--;
			}

			// decrement the element at index c1
			map[c1]--;

			// increase the window size move end pointer
			end++;

			// if all element of pattern found
			while (counter == 0) {

				// if min len found change it to new minLen and minStart
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}
				final char c2 = str.charAt(start);
				// increment count in map, before shrinking the window size
				map[c2]++;

				// if ignored element is from pattern then increment counter
				if (map[c2] > 0) {
					counter++;
				}
				// increment start to make it invalid/valid again
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
	}

}
