package com.koko.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class PascalTriangle {
	public List<List<Integer>> pascalTriangle(int numRows) {

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < i + 1; j++) {

				// First and last values in every row are 1
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					// get the above row
					int a = result.get(i - 1).get(j - 1);
					int b = result.get(i - 1).get(j);
					list.add(a + b);
				}
			}
			result.add(list);
		}
		return result;
	}
}
