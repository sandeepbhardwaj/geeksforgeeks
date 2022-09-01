package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate("(", 1, 0, result, n);
		return result;
	}

	static void generate(String current, int openCount, int closeCount, List<String> result, int n) {
		if (openCount == n && closeCount == n) {
			result.add(current);
		}

		if (openCount < n)
			generate(current + "(", openCount + 1, closeCount, result, n);

		if (closeCount < openCount) // Imp check < so we always add ( first
			generate(current + ")", openCount, closeCount + 1, result, n);
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
