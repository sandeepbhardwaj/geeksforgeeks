package com.geeksforgeeks.dp;

/**
 * Given a total and coins of certain denominations find number of ways total
 * can be formed from coins assuming infinity supply of coins
 * 
 * @author sandeep
 *
 */
public class CoinChangeProblem
{

	public static int changeCoin(int[] coins, int amount)
	{
		int numberOfCoins = coins.length;

		// array with numberOfCoins+1 and amount+1
		int[][] T = new int[numberOfCoins + 1][amount + 1];

		// loop through coins
		for (int i = 0; i <= numberOfCoins; i++)
		{
			// loop through amount
			for (int j = 0; j <= amount; j++)
			{

				// base condition
				if (i == 0)
				{
					if (j == 0)
					{
						T[i][j] = 1;
					}
					// to fill first row
					else
					{
						T[i][j] = 0;
					}
				} else
				{
					// if coin is greater than amount
					if (coins[i - 1] > j)
					{
						T[i][j] = T[i - 1][j];
					} else
					{
						// exclude the new + include the new (in same row)
						T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];
					}
				}

			}
		}

		displayMatrix(numberOfCoins, amount, T);

		return T[numberOfCoins][amount];
	}

	private static void displayMatrix(int m, int n, int[][] T)
	{
		for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				System.out.print(T[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int amount = 10;
		int[] v = { 2, 5, 3, 6 };
		System.out.println("By Dynamic Programming " + changeCoin(v, amount));
	}

}
