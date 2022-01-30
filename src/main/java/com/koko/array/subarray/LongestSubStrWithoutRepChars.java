package com.koko.array.subarray;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStrWithoutRepChars {
	public static int lengthOfLongestSubstring(String s) {
		// base case
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();
		int left = 0;
		int right = 0;
		int max = 0;

		while (right < s.length() && left <= right) {
			//add and return true if set did not already contain the specified element
			if (set.add(s.charAt(right))) {
				// move to next element to increase window size
				right++;
			} else {
				// shrink the window size
				set.remove(s.charAt(left));
				left++;
			}
			max = Math.max(max, set.size());

		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}