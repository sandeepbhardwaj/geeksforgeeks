package com.koko.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
 * answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemperature {
	public static int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();

		Arrays.fill(result, 0);

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i); //adding index of element
		}
		return result;
	}

	public static void main(String[] args) {
		int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		Arrays.stream(dailyTemperatures(temperatures)).forEach(e -> System.out.print(e + ","));//[1,1,4,2,1,1,0,0]
	}
}
