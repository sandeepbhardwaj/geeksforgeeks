package com.interview.clearwater;

import java.util.Arrays;

/**
 * Anagram
 * <p>
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 * <p>
 * Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of characters
 * to change to make the two substrings into anagrams of one another.
 * <p>
 * Example
 * <p>
 * Break  into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous and their
 * lengths are equal. Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which
 * are anagrams. Two changes were necessary.
 * <p>
 * Function Description
 * <p>
 * Complete the anagram function in the editor below.
 * <p>
 * anagram has the following parameter(s):
 * <p>
 * string s: a string
 * Returns
 * <p>
 * int: the minimum number of characters to change or -1.
 */
public class Anagram {
	public static int anagram(String s) {
		//base case string can't be divided equally
		if (s.length() % 2 != 0)
			return -1;

		//end index exclusive
		String s1 = s.substring(0, s.length() / 2);
		String s2 = s.substring(s.length() / 2, s.length());

		int[] map = new int[128];

		for (char c : s1.toCharArray())
			map[c]++;

		for (char c : s2.toCharArray())
			map[c]--;

		/*int count = 0;
		for (int i : map) {
			if (i < 0) {
				count = count + Math.abs(i);
			}
		}*/

		long count = Arrays.stream(map)
				.filter(i -> i < 0)
				.mapToLong(i -> i)
				.reduce(0, (a1, a2) -> Math.abs(a1) + Math.abs(a2));

		return (int) count;
	}

	public static void main(String[] args) {
		System.out.println(anagram("aaabbb"));
		//System.out.println(anagram("mnop"));
	}
}
