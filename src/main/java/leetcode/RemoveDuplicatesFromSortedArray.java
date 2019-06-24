package leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int unique = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] != nums[i]) {
				nums[unique] = nums[i];
				unique++;
			}
		}
		return unique;
	}
}