package com.koko.queue;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
 * functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * <p>
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
 * operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque
 * (double-ended queue) as long as you use only a stack's standard operations.
 * <p>
 * Example 1:
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * <p>
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class MyQueue {

	Stack<Integer> input = null;
	Stack<Integer> output = null;

	/**
	 * Initialize your data structure here.
	 */
	public MyQueue() {
		input = new Stack();
		output = new Stack();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		input.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		peek();
		return output.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (output.empty())
			while (!input.empty())
				output.push(input.pop());
		return output.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return input.empty() && output.empty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
