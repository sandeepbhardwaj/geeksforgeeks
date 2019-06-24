package leetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int count = 0;
		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			if (nums[i] == val && nums[j] != val) {
				nums[i] = nums[j];
				count++;
				j--;
				i++;
			} else if (nums[i] != val) {
				i++;
				count++;
			} else if (nums[j] == val) {
				j--;
			}
		}
		return count;
	}
}