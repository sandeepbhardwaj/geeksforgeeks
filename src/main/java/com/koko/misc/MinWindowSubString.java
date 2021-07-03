package com.koko.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * <p>
 * Example: Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 *
 * @author sandeep
 */
public class MinWindowSubString {

	public static void main(String[] args) {
		String str = "badaabcccdasfasabcd";

		StringBuilder sb = new StringBuilder();
		Set<Character> mySet = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			if (mySet.add(c)) {
				sb.append(c);
			}
		}
		String pattern = sb.toString();
		System.out.println("Input string :" + str + " Pattern :" + pattern);
		System.out.println("Min Window :" + minWindow("badaabcccdasfasabcd", pattern));
	}

	/**
	 * decrement map counter for end, increment map counter for start
	 * <p>
	 * decrement count for end if element from pattern found, increment count for
	 * start if element from pattern found.
	 *
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static String minWindow(String str, String pattern) {

		// base case
		if (str == null || str.length() == 0)
			return "";

		int[] patternMap = new int[128];
		// populate the map with count of elements for pattern
		for (char c : pattern.toCharArray()) {
			patternMap[c]++;
		}

		int start = 0, end = 0; // variable for sliding window
		int minLen = Integer.MAX_VALUE; // variable to hold min window len
		int minStart = 0; // minStart to hold the output window start index
		int count = pattern.length(); // count with length of pattern

		// till end is less than str size
		while (end < str.length()) {
			char c = str.charAt(end);

			// if pattern char found in str
			if (patternMap[c] > 0) {
				count--;
			}

			patternMap[c]--;
			end++;

			// found all character of pattern
			// update the result and reduce the window
			while (count == 0) {
				// verify/change the minLen
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}

				patternMap[str.charAt(start)]++;

				if (patternMap[str.charAt(start)] > 0) {
					count++;
				}
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
	}

}
