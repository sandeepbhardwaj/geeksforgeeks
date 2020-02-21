package com.geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
	private LinkedHashMap<T, List<T>> graph = new LinkedHashMap<>();

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.traverse();
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(2);
	}

	public void addEdge(T source, T dest) {
		// adding source
		if (!graph.containsKey(source)) {
			List<T> list = new LinkedList<T>();
			graph.put(source, list);
		}

		// adding destination
		if (!graph.containsKey(dest)) {
			List<T> list = new LinkedList<T>();
			graph.put(dest, list);
		}

		// linking source with destination
		List<T> l = graph.get(source);
		l.add(dest);
	}

	public void bfs(T source) {
		List<T> visited = new ArrayList<>();
		// Create a queue for BFS
		LinkedList<T> queue = new LinkedList<T>();

		// add vertex in queue
		queue.push(source);
		// make it visited
		visited.add(source);

		while (!queue.isEmpty()) {
			// dequeue the vertex
			T vertex = queue.poll();
			System.out.print(vertex + " > ");

			List<T> list = graph.get(vertex);

			for (T t : list) {
				if (!visited.contains(t)) {
					queue.add(t);
					visited.add(t);
				}
			}
		}
	}

	public void traverse() {
		for (T i : graph.keySet()) {
			System.out.print(i + " -> ");
			for (T l : graph.get(i)) {
				System.out.print(l + " -> ");
			}
			System.out.println();
		}
	}
}
