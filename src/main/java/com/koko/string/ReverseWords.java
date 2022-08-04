package com.koko.string;

import org.junit.Assert;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
 * and initial word order.
 * <p>
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * <p>
 * Convert string to char array to avoid having to deal with separate strings (since concatenation is an expensive
 * operation).
 * Go through char array, keeping pointer start at the beginning of words and pointer end iterating through whole array
 * checking for white space.
 * If white space is found, call function reverse() on char array to reverse chars between start and end-1 (inclusive)
 * Once loop is finished, start now points to start of last word and end points to the last+1 index of char array
 * Thus, need to call reverse once again to reverse the last word.
 * Return char array as a String
 */
public class ReverseWords {
	public static String reverseWords(String s) {
		int start = 0;
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == ' ') {
				reverse(arr, start, i - 1);
				start = i + 1;
			}
		}

		reverse(arr, start, arr.length - 1);
		return new String(arr);
	}


	private static void reverse(char[] arr, int start, int end) {
		while (start <= end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		//System.out.println(reverseWords(s));
		Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",reverseWords(s));
	}
}
