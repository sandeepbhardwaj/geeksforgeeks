package com.koko.array;

/**
 * Calculate max profit in one iteration O(N)
 *
 * @author Sandeep
 */
public class BuyingSelling {

	public static void main(String[] args) {
		int[] stockPrices = {10, 13, 4, 6, 9};

		System.out.println("Profit :" + maxProfit(stockPrices));
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;
		int minBuyPrice = Integer.MAX_VALUE;

		for (int price : prices) {
			profit = Math.max(profit, price - minBuyPrice);
			minBuyPrice = Math.min(minBuyPrice, price);
		}

		return profit;
	}
}
