package com.koko.string;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) return false;

		int[] map = new int[26];

		for (char ch : s.toCharArray()) map[ch - 'a']++;

		for (char ch : t.toCharArray()) map[ch - 'a']--;

		for (int i : map) {
			if (i != 0) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("Is abc and bca is anagram :" + isAnagram("abc", "bca"));
	}
}