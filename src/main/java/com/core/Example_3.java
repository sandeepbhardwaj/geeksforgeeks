package com.core;

// execute it with passing x as program argument
public class Example_3 {
	public static void main(String[] args) {
		try {
			System.out.println(doStuff(args));
		}catch (Exception e)
		{
			System.out.println("exception");
		}
		doStuff(args);
	}
	static int doStuff(String[] args)
	{
		return Integer.parseInt(args[0]);
	}
}
