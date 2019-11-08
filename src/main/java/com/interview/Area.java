package com.interview;

public class Area {

}

class Circle {
	private float radius;

	public Circle(float radius) {
		this.radius = radius;
	}

	public int getArea(float radius) {
		return (int) Math.ceil(3.14 * radius * radius);
	}
}

class Rectangle {
	private float width;
	private float height;

	public Rectangle(float width, float height) {
		this.width = width;
		this.height = height;
	}

	public int getArea(float width, float height) {
		return (int) Math.ceil(width * height);
	}
}

class Square {
	private float width;

	public Square(float width) {
		this.width = width;
	}

	public int getArea(float width) {
		return (int) Math.ceil(width * width);
	}
}
