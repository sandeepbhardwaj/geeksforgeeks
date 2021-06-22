package com.leetcode.array;

/**
 * 12. Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: num = 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(3200));//MMMCC
		//System.out.println(intToRoman(5));
	}

	public static String intToRoman(int num) {
		//Total 13
		Numeral[] numerals = {
				new Numeral("M", 1000),
				new Numeral("CM", 900),
				new Numeral("D", 500),
				new Numeral("CD", 400),
				new Numeral("C", 100),
				new Numeral("XC", 90),
				new Numeral("L", 50),
				new Numeral("XL", 40),
				new Numeral("X", 10),
				new Numeral("IX", 9),
				new Numeral("V", 5),
				new Numeral("IV", 4),
				new Numeral("I", 1)
		};

		String result = "";
		for (Numeral numeral : numerals) {
			int noOfnumeral = num / numeral.value;

			// not zero it means num is greater or equals to than numeral value like 6 is greater than V aka 5
			if (noOfnumeral != 0) {
				// suppose 3200/1000= 3 then add three MMM
				result += numeral.symbol.repeat(noOfnumeral);
			}
			// 3200%1000 = 200
			num = num % numeral.value;

			//if num becomes zero then its resolved no need to loop further optimization
			if (num == 0) break;
		}
		return result;
	}

	/**
	 * Class to hold Roman symbol and its integral value
	 */
	static class Numeral {
		String symbol;
		int value;

		public Numeral(String symbol, int value) {
			this.symbol = symbol;
			this.value = value;
		}
	}
}