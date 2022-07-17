package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, result, new ArrayList<String>(), s);
        return result;
    }


    void backtrack(int start, List<List<String>> result, List<String> current, String s) {
        if (start >= s.length()) result.add(new ArrayList<String>(current));

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(end + 1, result, current, s);
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
