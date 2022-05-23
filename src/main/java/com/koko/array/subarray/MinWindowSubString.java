package com.koko.array.subarray;

import java.util.HashMap;
import java.util.Map;

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

	public static String minWindow1(String s, String t) {

		if (t.length() > s.length())
			return "";

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int left = 0;
		int right = 0;
		int counter = map.size();

		int minStart = 0;
		int minLen = Integer.MAX_VALUE;

		while (right < s.length()) {
			char ch = s.charAt(right);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);

				if (map.get(ch) == 0) {
					counter--;
				}
			}

			right++;

			while (counter == 0) {

				char tempc = s.charAt(left);

				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1); //increment the frequency of element again

					//if freq of char is > 0 then increment the counter
					if (map.get(tempc) > 0) {
						counter++;
					}
				}

				//update result
				if (minLen > right - left) {
					minLen = Math.min(minLen, right - left);
					minStart = left;
				}

				left++;

			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

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
			//only decrement count if its greater than 0
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

				//now reduce the window, required element count again greater than zero
				if (map[leftCh] > 0) {
					count++;
				}
				left++;
			}

			right++; //move the window
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		System.out.println("Min Window :" + minWindow1("ADOBECODEBANC", "ABC"));
		System.out.println("Min Window :" + minWindow1("bba", "ab"));
	}

}
