package com.koko.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 387. First Unique Character in a String
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
 * return -1.
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 */

public class FirstNonRepeatingCharacter {

	public static int firstUniqueChar(String s) {
		int freq[] = new int[26];

		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 1) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqueChar("abcdefghija"));
	}

}
