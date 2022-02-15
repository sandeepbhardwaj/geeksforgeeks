package com.koko.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Examples can be solved by template
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class SlidingWindowTemplate {
	public List<Integer> slidingWindowTemplate(String s, String t) {
		//init a collection or int value to save the result according the question.
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length()) return result;

		//create a hashmap to save the Characters of the target substring.
		//(K, V) = (Character, Frequence of the Characters)
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		//maintain a counter to check whether match the target string.
		int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

		//Two Pointers: left - left pointer of the window; right - right pointer of the window
		int left = 0, right = 0;

		//the length of the substring which match the target string.
		int len = Integer.MAX_VALUE;

		//loop at the beginning of the source string
		while (right < s.length()) {

			char c = s.charAt(right);//get a character

			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);// plus or minus one
				if (map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
			}
			right++;

			//increase left pointer to make it invalid/valid again
			while (counter == 0 /* counter condition. different question may have different condition */) {

				char tempc = s.charAt(left);//***be careful here: choose the char at left pointer, NOT the right pointer
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);//plus or minus one
					if (map.get(tempc) > 0)
						counter++;//modify the counter according the requirement(different condition).
				}

				/* save / update(min/max) the result if find a target*/
				// result collections or result int value

				left++;
			}
		}
		return result;
	}
}
