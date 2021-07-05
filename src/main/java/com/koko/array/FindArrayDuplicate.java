package com.koko.array;

import java.util.Collections;
import java.util.List;

public class FindArrayDuplicate {

	private static boolean isDuplicate(List<Integer> arr) {
		Collections.sort(arr);
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i) == arr.get(i + 1)) {
				return true;
			}
		}
		return false;
	}
}
