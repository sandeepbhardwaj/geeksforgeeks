package com.geeksforgeeks.sorting;

public class BubbleSort
{

	public static void main(String[] args)
	{
		int[] arr = { 4, 2, 6, 1, 8, 10, 5 };

		bubbleSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

	}

	private static void bubbleSort(int[] arr)
	{
		int n = arr.length;

		while (n > 1)
		{
			for (int i = 0; i < arr.length - 1; i++)
			{
				if (arr[i] > arr[i + 1])
				{
					// swap
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
			n--;
		}
	}

}
