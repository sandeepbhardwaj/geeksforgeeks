package com.core;

class A {
}

class B extends A {
}

class C extends B {
}

public class Example_5 {
	public static void main(String[] args) {
		B b = new B();
		boolean flag = (b instanceof B) && (!(b instanceof A));
		System.out.println(flag);
	}
}
