package com.koko.string;

public class Anagram {
	public static boolean isAnagram(String s, String t) {

		if (s == null || t == null)
			return false;

		if (s.length() != t.length())
			return false;

		int[] map = new int[128];

		for (char c : s.toCharArray())
			map[c]++;

		for (char c : t.toCharArray())
			map[c]--;

		for (int i : map) {
			if (i > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("IS abc and bca is anagram :" + isAnagram("abc", "bca"));
	}
}