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

			// number of elements in row is i+1, ex:- row zero contains 1 element
			for (int j = 0; j < i + 1; j++) {

				// First and last values in every row are 1
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					// get the above row
					List<Integer> prev = result.get(i - 1);
					// get the above elements
					list.add(prev.get(j - 1) + prev.get(j));
				}
			}
			result.add(list);
		}
		return result;
	}
}
