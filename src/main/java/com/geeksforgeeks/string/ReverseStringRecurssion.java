package com.geeksforgeeks.string;

public class ReverseStringRecurssion
{

	public static void main(String[] args)
	{
		String str = "test";

		str = reverse(str);
		System.out.println(str);
	}

	public static String reverse(String str)
	{
		if ((str == null) || (str.length() <= 1))
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}

}
