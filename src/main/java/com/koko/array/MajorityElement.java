package com.koko.array;

public class MajorityElement {

	//Moore’s Voting Algorithm
	public int majorityElement(int[] nums) {
		int count = 0;
		int element = -1;

		for (int num : nums) {
			if (count == 0) {
				element = num;
			}

			if (num == element) {
				count++;
			} else {
				count--;
			}
		}
		return element;
	}
}
