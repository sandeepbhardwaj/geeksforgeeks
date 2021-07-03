package com.koko.stack;

import java.util.Stack;

public class ReverseAndSortStack {

	public static <E> void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;

		int element = stack.pop();
		reverseStack(stack);

		insertAtBottom(stack, element);
		//insertInSortedOrder(stack, element);
	}

	private static <E> void insertAtBottom(Stack<Integer> stack, int element) {
		if (stack.isEmpty()) {
			stack.push(element);
			return;
		}

		int temp = stack.pop();
		insertAtBottom(stack, element);
		stack.push(temp);
	}

	private static <E> void insertInSortedOrder(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || element >= stack.peek()) {
			stack.push(element);
			return;
		}

		int temp = stack.pop();
		insertInSortedOrder(stack, element);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(2);

		System.out.println("Stack before reverse:" + stack);
		reverseStack(stack);
		System.out.println("Stack after reverse:" + stack);
	}

}
