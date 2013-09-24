package com.codemelon.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * MinHeap that can be used as priority queue for Dijkstra's algorithm.
 * <p>
 * Java's PriorityQueue doesn't support the necessary decrease-key()
 * operation, so we need a custom implementation. This one closely
 * follows CLRS, pp. 151ff.
 * <p>
 * The heap cannot contain multiple pointers to the same object.
 * An attempt to insert it a second time will not modify the heap.
 * 
 * @author Marshall Farrier
 * @since Sep 23, 2013
 */
public class MinHeap<T> {
	private ArrayList<T> heap;
	// for fast retrieval of item index
	private Map<T, Integer> map;
	private Comparator<? super T> c;
	// following Java implementation of PriorityQueue<T>
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	
	/**
	 * Creates an empty <code>MinHeap</code> with default initial capacity (11)
	 */
	public MinHeap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	/**
	 * Construct an empty <code>MinHeap</code> using the natural ordering for type T
	 * and specified initial capacity
	 */
	public MinHeap(int initialCapacity) {
		this(initialCapacity, new Comparator<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(T a, T b) {
				Comparable<? super T> key = (Comparable<? super T>) a;
				return key.compareTo(b);
			}
		});
	}
	
	/**
	 * Construct an empty <code>MinHeap</code> specifying the method for comparing
	 * objects of type T
	 */
	public MinHeap(int initialCapacity, Comparator<? super T> comparator) {
		this.heap = new ArrayList<T>(initialCapacity);
		c = comparator;
		initMap(initialCapacity);
	}
	
	/**
	 * Creates a <code>MinHeap</code> containing the elements in the specified collection, 
	 * compared using their natural ordering.
	 * <p>
	 * The <code>items</code> collection cannot contain duplicates due to the mechanism 
	 * used to ensure a fast extractMin() method. Items a and b may exist in the collection
	 * such that a.compareTo(b) == 0 but not such that a == b.
	 * 
	 * @param items
	 * @param comparator
	 * @throws IllegalArgumentException if the collection contains duplicates.
	 */
	public MinHeap(Collection<? extends T> items) {
		this(items, new Comparator<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(T a, T b) {
				Comparable<? super T> key = (Comparable<? super T>) a;
				return key.compareTo(b);
			}
		});
	}
	
	/**
	 * Creates a <code>MinHeap</code> containing the elements in the specified collection, 
	 * compared using the given comparator.
	 * <p>
	 * The <code>items</code> collection cannot contain duplicates due to the mechanism 
	 * used to ensure a fast extractMin() method. Items a and b may exist in the collection
	 * such that c.compareTo(a, b) == 0 but not such that a == b.
	 * 
	 * @param items
	 * @param comparator
	 * @throws IllegalArgumentException if the collection contains duplicates.
	 */
	public MinHeap(Collection<? extends T> items, Comparator<? super T> comparator) {
		this.heap = new ArrayList<T>(items);
		initMap();
		buildMinHeap();
	}
	
	private void buildMinHeap() {
		// TODO
	}
	
	private void initMap(int initialCapacity) {
		map = new HashMap<T, Integer>(initialCapacity);
	}
	
	private void initMap() {
		map = new HashMap<T, Integer>(heap.size());
		for (int i = 0; i < heap.size(); i++) {
			if (map.containsKey(heap.get(i))) {
				throw new IllegalArgumentException("collection contains duplicates");
			}
			map.put(heap.get(i), i);
		}
	}
}
