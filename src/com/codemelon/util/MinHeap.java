package com.codemelon.util;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
public class MinHeap<T> extends AbstractQueue<T> {
	private ArrayList<T> heap;
	// for fast retrieval of item index
	private Map<T, LinkedList<Integer>> map;
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
	
	/**
	 * Inserts the specified item into this heap.
	 * <p>
	 * Note that if the item is already present, it is not inserted a second time.
	 * In this case, the method returns false and does not modify the heap.
	 * 
	 * @return true if the item is not already in the heap
	 */
	@Override
	public boolean add(T item) {
		return offer(item);
	}
	
	/**
	 * Returns the comparator used to order the elements in the heap.
	 * <p>
	 * If no comparator was passed when the heap was constructed, the comparator
	 * returned will enforce the natural ordering for objects of type T.
	 * 
	 * @return the comparator used to order the elements in the heap.
	 */
	public Comparator<? super T> comparator() {
		return c;
	}
	
	/**
	 * Removes all of the elements from this heap. The heap will be empty after this call returns.
	 * <p>
	 * The comparator for ordering elements of the heap remains unchanged.
	 */
	@Override
	public void clear() {
		heap = new ArrayList<T>(DEFAULT_INITIAL_CAPACITY);
		initMap(DEFAULT_INITIAL_CAPACITY);
	}
	
	/**
	 * Returns true if this heap contains the specified element.
	 * 
	 * @return true if this heap contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	/**
	 * Inserts the specified item into this heap.
	 * 
	 * @return true if the item is not already in the heap
	 */
	@Override
	public boolean offer(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Retrieves, but does not remove, the head of this heap, or returns <code>null</code>
	 * if this queue is empty
	 * 
	 * @return the head of this heap
	 */
	@Override
	public T peek() {
		if (heap.size() == 0) { return null; }
		return heap.get(0);
	}

	/**
	 * Retrieves and removes the head of this heap, or returns <code>null</code> if this
	 * heap is empty.
	 * 
	 * @return the head of this heap, or <code>null</code> if this heap is empty
	 */
	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns an iterator over the elements in this heap. The iterator does not return the
	 * elements in any particular order.
	 * 
	 * @returns an iterator over the elements in this heap
	 */
	@Override
	public Iterator<T> iterator() {
		return heap.listIterator();
	}

	/**
	 * Returns the number of elements in this collection.
	 * 
	 * @returns the number of elements in this collection
	 */
	@Override
	public int size() {
		return heap.size();
	}
	
	private void buildMinHeap() {
		// TODO
	}
	
	private void initMap(int initialCapacity) {
		map = new HashMap<T, LinkedList<Integer>>(initialCapacity);
	}
	
	private void initMap() {
		map = new HashMap<T, LinkedList<Integer>>(heap.size());
		for (int i = 0; i < heap.size(); i++) {
			if (map.containsKey(heap.get(i))) {
				// map maintains as many copies as there are instances of the given item
				map.get(heap.get(i)).add(i);
			}
			else {
				map.put(heap.get(i), new LinkedList<Integer>());
				map.get(heap.get(i)).add(i);
			}
		}
	}
}
