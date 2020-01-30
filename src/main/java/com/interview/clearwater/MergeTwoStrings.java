package com.interview.clearwater;

public class MergeTwoStrings {
	public static void main(String[] args) {
		System.out.println(merge("abc", "abcdd"));
	}

	public static String merge(String a, String b) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < a.length() || i < b.length(); i++) {
			if (i < a.length()) {
				res.append(a.charAt(i));
			}
			if (i < b.length()) {
				res.append(b.charAt(i));
			}
		}
		return res.toString();
	}
}
