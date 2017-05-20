package com.geeksforgeeks.string;

/**
 * <pre>
 * Bomber Algo: The bomber algorithm doesn't like consecutive characters in a
 * given string to be same. For Example: If the given string is abcccbd the
 * bomber algo will first bomb ccc and then bb, so the final output string will
 * become ad. The bomber algo will destroy the characters only if there are more
 * than 1 continuous occurrence of same characters in the string.
 * 
 * Write a code of the bomber algo. The method takes a string as an input and
 * returns the bombed string as an output.
 * 
 * If you are taking any assumptions, please do mention them before the code!
 * 
 * Examples:
 * 
 * Input 1: aabcccdee<br/>
 * Output: bd<br/>
 * Explanation <br/>
 * Step 1: aabcccdee<br/>
 * Step 2: bcccdee<br/>
 * Step 2: bdee<br/>
 * Step 3: bd (Final Answer) <br/>
 * 
 * Input 2: abcdeedcbfgf<br/>
 * Output : afgf<br/>
 * Explanation <br/>
 * Step 1: eeabcddcbfgf<br/>
 * Step 2: abcddcbfgf<br/>
 * Step 3: abccbfgf<br/>
 * Step 4: abbfgf<br/>
 * Step 5: afgf (Final Answer)<br/>
 * 
 * Input 3: abbabba<br/>
 * Output: a<br/>
 * Explanation <br/>
 * Step 1: aabba<br/>
 * Step 2: bba<br/>
 * Step 3: a (Final Answer)<br/>
 * <pre>
 * 
 * @author sandeep
 *
 */

public class BombedStringExample
{

	public static void main(String[] args)
	{

		String str = "abbabba";
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++)
		{
			boolean flag = false;
			int occurrence = 1;
			for (int j = i + 1; j < sb.length(); j++)
			{
				if (sb.charAt(i) == sb.charAt(j))
				{
					flag = true;
					occurrence++;
				}
				else
				{
					break;
				}
			}

			if (flag)
			{
				// remove the bombarded string
				sb.delete(i, occurrence + i);
				i = 0;
				System.out.println("steps :" + sb.toString());
			}
		}
		System.out.println(sb.toString());
	}

}
