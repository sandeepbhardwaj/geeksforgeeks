package com.koko.array.subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {
	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();

		if (p.length() > s.length())
			return result;

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : p.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int left = 0;
		int right = 0;
		int counter = map.size();

		while (right < s.length()) {
			char ch = s.charAt(right);

			//check char exist in map
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1); //reduce the frequency of element

				//if freq of char is 0 then reduce the counter
				if (map.get(ch) == 0) {
					counter--;
				}
			}

			right++;

			//if found all the char of pattern
			while (counter == 0) {

				char temp = s.charAt(left);

				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1); //increment the frequency of element again

					//if freq of char is > 0 then increment the counter
					if (map.get(temp) > 0) {
						counter++;
					}
				}

				//if length of window and pattern is same
				if (right - left == p.length()) {
					// add the start index of anagram to result
					result.add(left);
				}

				left++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";

		System.out.println(findAnagrams(s, "abc"));
	}
}
