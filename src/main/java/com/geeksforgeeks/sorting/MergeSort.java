package com.geeksforgeeks.sorting;

public class MergeSort
{

	public static void main(String[] args)
	{
		int[] arr = { 4, 2, 6, 1, 8, 10, 5 };

		sort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	// method for split and sort the array
	public static void sort(int[] arr)
	{
		int length = arr.length;

		// base case
		if (length < 2)
		{
			return;
		}

		int mid = length / 2;

		// create temporary array
		int[] left = new int[mid];
		int[] right = new int[length - mid];

		// populate the temporary array
		for (int i = 0; i < mid; i++)
		{
			left[i] = arr[i];
		}

		for (int i = 0; i < length - mid; i++)
		{
			right[i] = arr[mid + i];
		}

		sort(left);
		sort(right);
		merge(left, right, arr);
	}

	// for merging of two sub arrays
	public static void merge(int[] left, int[] right, int[] arr)
	{
		// int size = arr.length;
		int lSize = left.length;
		int rSize = right.length;

		int k = 0, l = 0, r = 0;

		while (l < lSize && r < rSize)
		{
			if (left[l] <= right[r])
			{
				arr[k] = left[l];
				k++;
				l++;
			} else
			{
				arr[k] = right[r];
				k++;
				r++;
			}
		}

		while (l < lSize)
		{
			arr[k] = left[l];
			k++;
			l++;
		}

		while (r < rSize)
		{
			arr[k] = right[r];
			k++;
			r++;
		}

	}

}
