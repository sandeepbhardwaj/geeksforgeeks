package com.leetcode.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {
	Stack<Integer> stack = null;
	Stack<Integer> minStack = null;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);

		// if new val is smaller than existing element
		if (minStack.isEmpty() || minStack.peek() >= val) {
			minStack.push(val);
		}
       /* else
        {
            //add top value again
            minStack.push(minStack.peek());
        }*/
	}

	public void pop() {
		int val = stack.pop();

		//change pop behavious
		if (val == minStack.peek())
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
