package com.interview.clearwater;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatedChar("abcdefghija"));

		System.out.println(getFirstNonRepeatedCharUsingArray("abcdefghija"));

	}

	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	public static char getFirstNonRepeatedCharUsingArray(String str) {
		int[] map = new int[128];

		Arrays.fill(map, 0);

		for (char c : str.toCharArray()) {
			map[c]++;
		}

		for (int i = 0; i < map.length; i++) {
			if (map[i] == 1) {
				char c = (char) i;
				return c;
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

}
