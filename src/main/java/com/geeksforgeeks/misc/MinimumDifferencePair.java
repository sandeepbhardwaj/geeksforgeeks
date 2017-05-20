package com.geeksforgeeks.misc;

import java.util.Scanner;

public class MinimumDifferencePair
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		int noOfTestCases = sc.nextInt();

		for (int i = 0; i < noOfTestCases; i++)
		{
			int sizeOfArr = sc.nextInt();
			int[] arr = new int[sizeOfArr];
			for (int k = 0; k < sizeOfArr; k++)
			{
				arr[k] = sc.nextInt();
			}

			// logic here
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < sizeOfArr; k++)
			{
				int j = k + 1;
				while (j < sizeOfArr)
				{
					min =Math.min(min,Math.abs( arr[k] - arr[j]));
					j++;
				}
			}
			System.out.println(min);

		}
		sc.close();

	}

}
