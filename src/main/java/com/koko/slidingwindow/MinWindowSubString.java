package com.koko.slidingwindow;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty
 * string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * @author sandeep
 */
public class MinWindowSubString {

	public static String minWindow(String s, String t) {

		if (t.length() > s.length())
			return "";

		int left = 0;
		int right = 0;
		int count = t.length();
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;


		//populate t frequency map
		int[] map = new int[256];
		for (char ch : t.toCharArray()) {
			map[ch]++;
		}

		//sliding window login starts here
		while (left <= right && right < s.length()) {
			char ch = s.charAt(right);

			//check is this exist in map
			if (map[ch] > 0) {
				count--; // one matching element found;
			}
			map[ch]--; // reduce the frequency of that char

			//window found that contains all char
			while (count == 0) {
				if (minLen > right - left + 1) {
					minLen = Math.min(minLen, right - left + 1);
					minStart = left;
				}

				char leftCh = s.charAt(left);
				map[leftCh]++;

				//now reduce the window
				if (map[leftCh] > 0) {
					count++;
				}
				left++;
			}

			right++; //move the window
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public static String minWindow1(String s, String t) {
		//base case
		if (t.length() > s.length())
			return "";

		//map to hold the frequency
		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}


		int left = 0;
		int right = 0;
		int count = t.length(); // no of char in pattern
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;

		//sliding window condition
		while (right < s.length() && left <= right) {
			char c = s.charAt(right);
			//char found in pattern , decrement count and fequency of that element
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				//count--;
			}

			if (map.containsKey(c) && map.get(c) >= 0) {
				count--;
			}

			//increment window
			right++;

			//if we found all elements
			while (count == 0) {

				//if new minLen found update the minLen
				if (minLen > right - left) {
					minLen = right - left;
					minStart = left;
				}

				char leftChar = s.charAt(left);
				if (map.containsKey(leftChar)) {
					map.put(leftChar, map.get(leftChar) + 1);

				}

				if (map.containsKey(leftChar) && map.get(leftChar) > 0) {
					count++;
				}
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		System.out.println("Min Window :" + minWindow("ADOBECODEBANC", "ABC"));
		//System.out.println("Min Window :" + minWindow("bba", "ab"));
	}

}
