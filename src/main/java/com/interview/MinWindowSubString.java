package com.interview;

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
	public static String minWindow(String s, String t) {

		// base case
		if (s == null || s.length() == 0)
			return "";

		int[] map = new int[128];
		// populate the map with count of elements for pattern
		for (char c : t.toCharArray()) {
			map[c]++;
		}

		// variable for sliding window
		int start = 0, end = 0;

		// variable to hold min window len
		int minLen = Integer.MAX_VALUE;

		// minStart to hold the output window start index
		int minStart = 0;

		// count with length of pattern
		int count = t.length();

		// till end is less than str size
		while (end < s.length()) {
			char c = s.charAt(end);

			// if pattern char found in str
			if (map[c] > 0) {
				count--;
			}

			map[c]--;
			end++;

			// found all character of pattern
			while (count == 0) {
				// verify/change the minLen
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}

				// reduce the size of window
				map[s.charAt(start)]++;

				if (map[s.charAt(start)] > 0) {
					count++;
				}

				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

}
