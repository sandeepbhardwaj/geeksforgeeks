package com.koko.string;

/**
 * 844. Backspace String Compare
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a
 * backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * <p>
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * <p>
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {

		int i = s.length() - 1;
		int j = t.length() - 1;

		int sCount = 0;
		int tCount = 0;

		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					sCount++;
					i--;
				} else if (sCount > 0) {
					sCount--;
					i--;
				} else
					break;
			}

			while (j >= 0) {
				if (t.charAt(j) == '#') {
					tCount++;
					j--;
				} else if (tCount > 0) {
					tCount--;
					j--;
				} else
					break;
			}

			//characters are not equal
			if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
				return false;
			}

			//if one string is done and other having characters
			if ((i >= 0) != (j >= 0))
				return false;

			i--;
			j--;
		}
		return true;
	}
}
