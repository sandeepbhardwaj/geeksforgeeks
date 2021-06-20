package com.leetcode.string;

import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * <p>
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters
 * from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * <p>
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * <p>
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class WordCompression {
	public static String wordCompression(String s, int k) {
		Stack<Pair<Character, Integer>> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().key == c) {
				Pair<Character, Integer> pair = stack.pop();
				pair.value = pair.value + 1;
				if (pair.value != k) {
					stack.push(pair);
				}
			} else {
				stack.push(new Pair<Character, Integer>(c, 1));
			}
		}

		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			Pair<Character, Integer> pair = stack.pop();
			//repeat method to repeat the char n number of times
			sb.append(pair.key.toString().repeat(pair.value));
		}

		return sb.reverse().toString();
	}

	//class to hold character and it's frequency
	static class Pair<K, V> {
		K key;
		V value;

		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		System.out.println(wordCompression("abbcccb", 3)); //a
	}
}
