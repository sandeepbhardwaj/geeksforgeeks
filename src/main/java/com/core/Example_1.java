package com.core;

public class Example_1 {
	class Inner {
		void test() {
			if (Example_1.this.flag)
				sample();
		}
	}

	private boolean flag = true;

	void sample() {
		System.out.println("sample");
	}

	public Example_1() {
		(new Inner()).test();
	}

	public static void main(String[] args) {
		new Example_1();
	}
}
