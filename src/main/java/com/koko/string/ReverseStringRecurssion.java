package com.koko.string;

public class ReverseStringRecurssion {

	public static void main(String[] args) {
		String str = "Hello";

		str = reverse(str);
		System.out.println(str);
	}

	public static String reverse(String str) {
		if ((str == null) || (str.length() == 0))
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}

}
