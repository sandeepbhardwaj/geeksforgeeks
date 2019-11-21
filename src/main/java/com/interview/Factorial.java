package com.interview;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(fact(5));

	}

	public static int factorial(int number) {
		int fact = 1;
		for (int i = 1; i <= number; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static int fact(int number) {
		if (number == 0)
			return 1;

		return number * fact(number - 1);
	}

}
