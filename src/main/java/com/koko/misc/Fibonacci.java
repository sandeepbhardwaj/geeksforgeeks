package com.koko.misc;

// Fn = Fn-1 + Fn-2
// F0 = 0 and F1 = 1
class Fibonacci {

	public static void main(String args[]) {
		int n = 5;
		System.out.println(fib(n));
		generateFibonacciSeries(n);
	}

	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static void generateFibonacciSeries(int count) {
		int n1 = 0, n2 = 1, n3;
		System.out.print(n1 + " " + n2);// printing 0 and 1

		for (int i = 2; i <= count; ++i)// loop starts from 2 because 0 and 1 are already printed
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
	}
}