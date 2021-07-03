package com.koko.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNumber {

	public static int[] nextGreaterElement(int[] nums) {
		int[] nge = new int[nums.length];

		//fill array to -1
		Arrays.fill(nge, -1);

		//stack of index
		Stack<Integer> stack = new Stack<>();

		//logic
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				int index = stack.pop();
				nge[index] = nums[i];
			}

			stack.push(i);
		}
		return nge;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 2};
		Arrays.stream(nextGreaterElement(nums)).forEach(result -> System.out.print(result + " "));
	}
}
