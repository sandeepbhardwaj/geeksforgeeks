package com.koko.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatedChar("abcdefghija"));
		System.out.println(firstUniqChar("abcdefghija"));
	}

	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

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
	 *
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		int freq[] = new int[26];

		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}

}
