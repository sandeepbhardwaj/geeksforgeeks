package com.interview.clearwater;

import java.util.Arrays;
import java.util.List;

public class WordChecker {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("sandeep", "jitender");
		List<Check> checks = Arrays.asList(new PalindromeCheck("PalindromeCheck"), new EmptyCheck("EmptyCheck"));

		WordCheckContext checkContext = new WordCheckContext(words, checks);
		checkContext.applyCheck();
	}
}

/*
 * context object whose behavior varies as per its strategy(check) object. The strategy
 * object changes the executing algorithm of the context object.
 */
class WordCheckContext {
	private List<String> words;
	private List<Check> checks;

	public WordCheckContext(List<String> words, List<Check> checks) {
		this.words = words;
		this.checks = checks;
	}

	public void applyCheck() {
		for (String word : words) {
			for (Check check : checks) {
				System.out.println("Applying check " + check.getCheckName() + "on " + word);
				if (!check.applyCheck(word)) {
					break;
				}
			}
		}
	}

}

/*
 * open close principle :- open for extension and closed for modification Can
 * add n number of check strategies do not need to modify existing classes
 */
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
		System.out.println("Apply " + getCheckName());
		return false;
	}
}

class EmptyCheck extends Check {
	public EmptyCheck(String checkName) {
		super(checkName);
	}

	@Override
	public boolean applyCheck(String input) {
		System.out.println("Apply " + getCheckName());
		return false;
	}
}