package com.koko.array.subarray;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Not working
 */
public class LongestUniqueCharactersSubstringOfSizeK {
	public static int longestkSubstr(String s, int k) {
		int result = 0;

		Set<Character> set = new HashSet<>();

		int left = 0;
		int right = 0;

		while (right < s.length()) {
			char rightChar = s.charAt(right);

			set.add(rightChar);

			if (set.size() < k) {
				right++;
			} else if (set.size() == k) {
				//update the result
				result = Math.max(result, right - left + 1);
				right++;
			} else // if set size is greate than k
			{
				while (set.size() > k) {
					set.remove(s.charAt(left));
					left++;
				}
				right++;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		String str = "aabacbebebe";
		int k = 3;

		longestkSubstr(str, k);
	}
}
