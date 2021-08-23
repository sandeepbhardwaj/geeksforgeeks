package com.koko.array;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n
 * <p>
 * The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n.
 */
public class CheckPrimeNumber {

	public static int sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) count++;
		}
		return count;
	}


	public static void main(String[] args) {
		sieveOfEratosthenes(50);
	}
}
