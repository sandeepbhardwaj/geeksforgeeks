package com.koko.string;

public class StrStr {
	public static int strStr(String haystack, String needle) {

		if (haystack.length() == 0 && needle.length() == 0) return 0;

		if (needle.length() > haystack.length()) return -1;

		int n = needle.length();

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {

			int found = 0;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) == needle.charAt(j)) {
					found++;
				} else {
					break;
				}
			}

			if (found == needle.length()) return i;

		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "hello", needle = "o";
		System.out.println(strStr(haystack, needle));
	}
}
