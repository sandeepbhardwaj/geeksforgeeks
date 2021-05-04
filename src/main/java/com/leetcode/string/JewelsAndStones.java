package com.leetcode.string;

/**
 * 771. Jewels and Stones
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {
	public static void main(String[] args) {
		String jewels = "aA", stones = "aAAbbbb";

		int noOfJewels = numJewelsInStones(jewels, stones);
		System.out.println(noOfJewels);
	}

	public static int numJewelsInStones(String jewels, String stones) {
		//create array to hold all alphabets

		boolean[] markedJewels = new boolean['z' + 1];

		int noOfJewels = 0;

		//marked the jewels
		for (int i = 0; i < jewels.length(); i++) {
			markedJewels[jewels.charAt(i)] = true;
		}

		//find the jewels in stones
		for (int i = 0; i < stones.length(); i++) {
			if (markedJewels[stones.charAt(i)]) {
				noOfJewels++;
			}
		}

		return noOfJewels;
	}
}


