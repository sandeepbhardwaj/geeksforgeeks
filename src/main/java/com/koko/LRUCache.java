package com.koko;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the
 * cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */
public class LRUCache {
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);

	Map<Integer, Node> cache;
	int capacity;

	public LRUCache(int capacity) {
		cache = new HashMap<>();
		this.capacity = capacity;

		head.next = tail;
		tail.prev = head; //  head -> Prev ,  head <- tail
	}

	public int get(int key) {
		int result = -1;

		Node node = cache.get(key);
		if (node != null) {
			//move node to head
			result = node.value;
			removeNode(node);
			addNode(node);
		}
		return result;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);

		//existing value
		if (node != null) {
			//override value
			node.value = value;
			removeNode(node);
			addNode(node);
		} else {
			if (capacity == cache.size()) {
				cache.remove(tail.prev.key); //remove from map
				removeNode(tail.prev); //remove last node
			}

			node = new Node(key, value);
			cache.put(key, node);
			addNode(node);
		}

	}

	//always add to head
	private void addNode(Node node) {
		//head --> head_next
		// We have to insert the new node in between head and head_next
		Node head_next = head.next; // initially its tail

		//head <- node -> head_next
		node.prev = head;
		node.next = head_next;

		// head -> node <- head_next
		head_next.prev = node;
		head.next = node;
	}

	//remove the given node
	private void removeNode(Node node) {
		// node_prev --> node ---> node_next
		Node node_prev = node.prev;
		Node node_next = node.next;

		node_prev.next = node_next;
		node_next.prev = node_prev;
	}

	//class to represent DoublyLinkedList
	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */