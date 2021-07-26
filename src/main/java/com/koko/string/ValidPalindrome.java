package com.koko.string;

/**
 * 125. Valid Palindrome
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		char[] c_arr = s.toCharArray();

		for (int i = 0, j = c_arr.length - 1; i < j; ) {
			if (!Character.isLetterOrDigit(c_arr[i])) {
				i++;
			} else if (!Character.isLetterOrDigit(c_arr[j])) {
				j--;
			} else if (Character.toLowerCase(c_arr[i++]) != Character.toLowerCase(c_arr[j--])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}
