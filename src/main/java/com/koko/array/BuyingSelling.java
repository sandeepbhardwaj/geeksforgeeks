package com.koko.array;

/**
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
 * to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
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
