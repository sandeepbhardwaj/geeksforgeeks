package com.koko.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 3, 5, 7);
		List<Integer> b = Arrays.asList(2, 4, 6, 7, 8);
		System.out.println(merge(a, b));

	}

	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		int i = 0;
		int j = 0;
		List<Integer> output = new ArrayList<Integer>();

		while (i < a.size() && j < b.size()) {
			if (a.get(i) < b.get(j)) {
				output.add(a.get(i++));
			} else {
				output.add(b.get(j++));
			}
		}

		while (i < a.size()) {
			output.add(a.get(i++));
		}

		while (j < b.size()) {
			output.add(b.get(j++));
		}

		return output;
	}

}
