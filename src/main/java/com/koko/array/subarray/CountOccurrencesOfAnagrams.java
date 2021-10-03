package com.koko.array.subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String / Count Occurences of Anagrams
 * <p>
 * Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
 * <p>
 * Example 1:
 * Input: txt = forxxorfxdofr, ptr = for
 * Output: 3
 * Explanation: for, orf and ofr appears in the txt, hence answer is 3.
 * <p>
 * Example 2:
 * Input: txt = aabaabaa , ptr = aaba
 * Output: 4
 * Explanation: aaba is present 4 times in txt.
 */
public class CountOccurrencesOfAnagrams {

	private static int countAnagrams(String str, String ptr) {
		int count = 0;
		int k = ptr.length();

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : ptr.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

		// variable that we will keep a count ,so we do not have to traverse the loop to see match
		int match = map.size();
		int left = 0, right = 0;

		while (right < str.length()) {
			char rightChar = str.charAt(right);
			if (map.containsKey(rightChar)) { // put the element and then reduce match
				map.put(rightChar, map.get(rightChar) - 1);

				if (map.get(rightChar) == 0)
					match--;
			}


			if (right - left + 1 < k) {
				right++;
			} else if (right - left + 1 == k) {
				if (match == 0)
					count++;

				char leftChar = str.charAt(left);
				if (map.containsKey(leftChar)) { // increment the match and then add to map

					//M.Imp before putting left char again do increment match
					if (map.get(leftChar) == 0)
						match++;

					map.put(leftChar, map.get(leftChar) + 1);
				}

				right++;
				left++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countAnagrams("forxxorfxdofr", "for"));
		System.out.println(countAnagrams("aabaa", "aa"));
	}
}
