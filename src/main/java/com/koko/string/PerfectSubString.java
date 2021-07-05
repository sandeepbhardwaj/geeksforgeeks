package com.koko.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Perfect SubString
 * There is s that consists of digits from 0 to 9, and an integer k. A substring s[L:R] (where 0 ≤ L ≤ R < sizeof(s) )
 * is a contiguous group of characters with s.  A substring is called a perfect substring if all of its elements occur
 * exactly k times.
 * <p>
 * For example,  s = 1102021222 and k = 2. Its 6 perfect substrings are:
 * s[0:1] = 11
 * s[0:5] = 110202
 * s[1:6] = 102021
 * s[2:5] = 0202
 * s[7:8] = 22
 * s[8:9] = 22
 * <p>
 * Calculate the number of perfect substrings in s.
 */
public class PerfectSubString {

	public static int perfectSubString(String s, int k) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			Map<Character, Integer> map = new LinkedHashMap<>();
			for (int j = i; j < s.length(); j++) {
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

				if (map.get(s.charAt(j)) == k && validate(map, k)) {
					System.out.println("[" + i + ":" + j + "]=" + s.substring(i, j + 1));
					result++;
				}

			}
		}
		return result;
	}

	private static boolean validate(Map<Character, Integer> map, int k) {
		for (Integer i : map.values()) {
			if (i != k)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "1102021222";
		int k = 2;
		System.out.println(perfectSubString(s, k));
	}
}
