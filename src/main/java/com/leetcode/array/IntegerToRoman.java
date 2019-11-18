package com.leetcode.array;

public class IntegerToRoman {
	
	public static void main(String[] args) {
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(49));
		
		System.out.println(1234%1000);
	}
	
	
	public static String intToRoman(int num) {
		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		
		return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
	}

}