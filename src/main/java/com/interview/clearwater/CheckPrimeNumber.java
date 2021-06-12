package com.interview.clearwater;

public class CheckPrimeNumber {

	public static void main(String[] args) {
		generatePrimeNumber(50);
	}

	public static void generatePrimeNumber(int n) {
		boolean isPrime = true;

		// Empty String
		String primeNumbersFound = "";
		for (int i = 1; i <= n; i++) {
			isPrime = isPrimeNumber(i);
			if (isPrime) {
				primeNumbersFound = primeNumbersFound + i + " ";
			}
		}
		System.out.println("Prime numbers from 1 to " + n + " are:");
		// Print prime numbers from 1 to maxCheck
		System.out.println(primeNumbersFound);
	}

	public static boolean isPrimeNumber(int num) {
		boolean flag = true;
		for (int i = 2; i <= num / 2; ++i) {
			// condition for non-prime number
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
