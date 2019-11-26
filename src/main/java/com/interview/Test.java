package com.interview;

public class Test {
	public static void main(String[] args) {
		Check palindromeCheck = new PalindromeCheck("PalindromeCheck");
		String input = "aba";
		palindromeCheck.applyCheck(input);
	}
}

abstract class Check {
	private String checkName;

	public Check(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	abstract public boolean applyCheck(String input);
}

class PalindromeCheck extends Check {
	public PalindromeCheck(String checkName) {
		super(checkName);
	}

	@Override
	public boolean applyCheck(String input) {
		System.out.println("Apply "+getCheckName());
		return false;
	}
}