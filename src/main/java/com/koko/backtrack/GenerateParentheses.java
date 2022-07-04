package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate("(", 1, 0, result, n);
		return result;
	}

	void generate(String current, int openCount, int closeCount, List<String> result, int n) {
		if (openCount == n && closeCount == n) {
			result.add(current);
		}

		if (openCount < n)
			generate(current + "(", openCount + 1, closeCount, result, n);

		if (closeCount < openCount)
			generate(current + ")", openCount, closeCount + 1, result, n);
	}
}
