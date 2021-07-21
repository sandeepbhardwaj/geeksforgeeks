package com.koko.binary;

public class NumberOf_1_Bits {

	//Brian Karnighan's algorithm
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	// using right shift
	public int hammingWeight1(int n) {
		int count = 0;
		while (n != 0) {
			count = count + (n & 1); // n & 1 return 0 or 1
			n = n >>> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int num = 00000000000000000000000000001011;
		System.out.println(hammingWeight(num));
	}
}
