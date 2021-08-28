package com.koko.string;

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
	public String reverseWords(String s) {

		char[] c = s.toCharArray();
		int start = 0, end = 0;
		for (; end < c.length; end++) {
			if (c[end] == ' ') {
				reverse(c, start, end - 1);
				start = end + 1;
			}
		}
		reverse(c, start, end - 1);
		return new String(c);
	}

	private void reverse(char[] c, int start, int end) {
		while (start < end) {
			char tmp = c[end];
			c[end] = c[start];
			c[start] = tmp;
			start++;
			end--;
		}
	}
}
