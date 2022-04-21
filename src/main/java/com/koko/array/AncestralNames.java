package com.koko.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AncestralNames {
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		//Total-7
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = map.get(s.charAt(s.length() - 1)); //get last element value

		for (int i = s.length() - 2; i >= 0; i--) {
			//last element is greater than next
			if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				result -= map.get(s.charAt(i));
			} else {
				result += map.get(s.charAt(i));
			}
		}
		return result;
	}

	public static String[] getSortedList(String[] names) {
		Arrays.sort(names, (s1, s2) -> {
			//split the strings up into name,roman
			String[] arr1 = s1.split(" ");
			String[] arr2 = s2.split(" ");

			//grab the numerical values of the romans
			int val1 = romanToInt(arr1[1]);
			int val2 = romanToInt(arr2[1]);

			//if the names are equal, compare the numerals
			if (arr1[0].equals(arr2[0])) {
				//if first one is greater than, push it back
				if (val1 > val2) {
					return 1;
				}
				//if first one is less than, stay same
				else {
					return -1;
				}
			} else { //if not same, just compare the names
				return arr1[0].compareTo(arr2[0]);
			}
		});
		return names;
	}

	public static void main(String[] args) {
		String[] names = {"Steven XVI", "Steven XVI", "David IX", "Steven XL", "Mary XV", "Mary XIII", "Mary XX"};
		System.out.println(Arrays.toString(getSortedList(names)));
	}
}
