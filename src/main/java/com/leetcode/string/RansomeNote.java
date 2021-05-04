package com.leetcode.string;

/**
 * 383. Ransom Note
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false
 * otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomeNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] marked = new int[26];

		for (int i = 0; i < ransomNote.length(); i++) {
			marked[ransomNote.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < magazine.length(); i++) {
			marked[magazine.charAt(i) - 'a'] -= 1;
		}

		for (int i : marked) {
			if (i >= 1) {
				return false;
			}
		}
		return true;
	}
}