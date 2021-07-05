package com.koko.array;

public class SortColors {
	public void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (low <= mid && mid <= high) {
			if (nums[mid] == 0) {
				//swap with low
				nums[mid] = nums[low];
				nums[low] = 0; //can assign 0 directly
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				//swap with high
				nums[mid] = nums[high];
				nums[high] = 2; // can assign 2 directly
				high--;
			}
		}
	}

}
