package com.koko.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.Collectors;

// LIFO 1,2,3
public class MyStack {
	int[] arr;
	int top = -1;
	int capacity;

	MyStack(int capacity) {
		arr = new int[capacity];
		this.capacity = capacity;
	}

	public void push(int element) {
		if (!isFull()) {
			arr[++top] = element;
			//top++;
		} else {
			System.out.println("Stack Full");
		}
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Empty");
			return -1;
		} else {
			//top--;
			return arr[top--];
		}
	}

	public void display() {
		String joined = Arrays.stream(arr)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(","));
		System.out.println(joined);
	}

	public int size() {
		return top + 1;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	private boolean isFull() {
		// array is 0 indexed so top=capacity-1
		return top == capacity - 1;
	}


	public static void main(String[] args) {
		MyStack stack = new MyStack(2);

		stack.push(1);
		stack.push(2);
		System.out.println("pop :" + stack.pop());
		stack.push(3);
		System.out.println("pop :" + stack.pop());
		System.out.println("pop :" + stack.pop());
		System.out.println("pop :" + stack.pop());
		System.out.println("size :" + stack.size());
		//stack.display();
	}
}
