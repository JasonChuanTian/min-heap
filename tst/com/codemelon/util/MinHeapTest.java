package com.codemelon.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * @author Marshall Farrier
 * @since Sep 24, 2013
 */
public class MinHeapTest {
	
	// test constructors
	/**
	 * Test method for {@link com.codemelon.util.MinHeap#MinHeap()}.
	 */
	@Test
	public void testMinHeap() {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		assertEquals("default constructor creates a heap of initial size 0", 0, heap.size());
		assertFalse("heap created by default constructor does not contain a test object", 
				heap.contains(0));
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#MinHeap(int)}.
	 */
	@Test
	public void testMinHeapInt() {
		MinHeap<Integer> heap = new MinHeap<Integer>(200);
		assertEquals("constructor with specified initial capacity creates a heap of initial size 0", 
				0, heap.size());
		assertFalse("heap created by capacity specification does not contain a test object", 
				heap.contains(0));
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#MinHeap(int, java.util.Comparator)}.
	 */
	@Test
	public void testMinHeapIntComparatorOfQsuperT() {
		MinHeap<Integer> heap = new MinHeap<Integer>(8, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		assertEquals("constructor with custom comparator creates a heap of initial size 0", 
				0, heap.size());
		assertFalse("heap with custom comparator does not initially contain a test object", 
				heap.contains(0));
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#MinHeap(java.util.Collection)}.
	 */
	@Test
	public void testMinHeapCollectionOfQextendsT() {
		Integer[] items = { 2, 1, 0, 2, 1 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		assertEquals("heap initialized with collection has correct size", 5, heap.size());
		for (int i = 0; i < items.length; i++) {
			assertTrue("heap contains " + items[i], heap.contains(items[i]));
		}
		assertEquals("correct head of heap", new Integer(0), heap.peek());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#MinHeap(java.util.Collection, java.util.Comparator)}.
	 */
	@Test
	public void testMinHeapCollectionOfQextendsTComparatorOfQsuperT() {
		Integer[] items = { 2, 1, 0, 2, 1 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items), new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		assertEquals("heap initialized with collection and comparator has correct size", 5, heap.size());
		for (int i = 0; i < items.length; i++) {
			assertTrue("heap contains " + items[i], heap.contains(items[i]));
		}
		assertEquals("correct head of heap with different comparator", new Integer(2), heap.peek());
	}
	
	/**
	 * Test method for {@link com.codemelon.util.MinHeap#size()}.
	 */
	@Test
	public void testSize() {
		Double[] items = { 3.14, 2.718, 1.0, 7.0 };
		MinHeap<Double> heap = new MinHeap<Double>(Arrays.asList(items));
		assertEquals("correct initial size", items.length, heap.size());
		heap.offer(1.0);
		assertEquals("correct size after adding another item", items.length + 1, heap.size());
		int timesToPoll = 3;
		for (int i = 0; i < timesToPoll; i++) {
			heap.poll();
		}
		assertEquals("correct size after polling " + timesToPoll + " times", 
				items.length + 1 - timesToPoll, heap.size());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#clear()}.
	 */
	@Test
	public void testClear() {
		Integer[] items = { 0, 1, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items), new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		heap.clear();
		Comparator<? super Integer> comparator = heap.comparator();
		assertEquals("heap size is 0", 0, heap.size());
		assertTrue("comparator still returns negative value for inputs 3, 2", 
				comparator.compare(3, 2) < 0);
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		Integer[] items = { 1, 3, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		heap.offer(0);
		assertEquals("heap has correct size", 4, heap.size());
		assertEquals("correct element at head of heap", new Integer(0), heap.peek());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#comparator()}.
	 */
	@Test
	public void testComparator() {
		MinHeap<Integer> heap = new MinHeap<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		Comparator<? super Integer> comparator = heap.comparator();
		assertTrue("comparator returns negative value for inputs 3, 2", comparator.compare(3, 2) < 0);
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsObject() {
		Integer[] items = { 0, 1, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		for (int i = 0; i < items.length; i++) {
			assertTrue("heap contains " + items[i], heap.contains(items[i]));
		}
		assertFalse("heap contains " + 3, heap.contains(3));
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#offer(java.lang.Object)}.
	 */
	@Test
	public void testOffer() {
		Integer[] items = { 1, 3, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		heap.offer(0);
		assertEquals("heap has correct size", 4, heap.size());
		assertEquals("correct element at head of heap", new Integer(0), heap.peek());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#peek()}.
	 */
	@Test
	public void testPeek() {
		Integer[] items = { 1, 0, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		assertEquals("correct value at head of queue", new Integer(0), heap.peek());
		assertEquals("correct size after calling peek()", 3, heap.size());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#poll()}.
	 */
	@Test
	public void testPoll() {
		Integer[] items = { 3, 1, 0, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		for (int i = 0; i < items.length; i++) {
			assertEquals("correct item polled", new Integer(i), heap.poll());
		}
		assertTrue("heap empty after all items have been polled", heap.isEmpty());
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#iterator()}.
	 */
	@Test
	public void testIterator() {
		String[] items = { "dog", "cat", "mouse", "aardvark", "giraffe" }; 
		MinHeap<String> heap = new MinHeap<String>(Arrays.asList(items));
		Set<String> bucket = new HashSet<String>(items.length);
		Iterator<String> it = heap.iterator();
		while (it.hasNext()) {
			bucket.add(it.next());
		}
		for (String item : items) {
			assertTrue("bucket contains \"" + item + "\"", bucket.contains(item));
		}
	}
	
	/**
	 * Test method for {@link com.codemelon.util.MinHeap#find()}.
	 */
	@Test
	public void testFind() {
		Integer[] items = { 3, 1, 2 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		assertEquals("correct index for smallest element", 0, heap.find(1));
		assertEquals("correct index for missing element", -1, heap.find(0));
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#get()}.
	 */
	@Test
	public void testGet() {
		Integer[] items = { 3, 1, 2, 1, 2, 0 };
		MinHeap<Integer> heap = new MinHeap<Integer>(Arrays.asList(items));
		assertEquals("correct smallest element", new Integer(0), heap.get(0));
		for (int i = 0; i < items.length; i++) {
			assertEquals("find() matches get() at index " + i, items[i], heap.get(heap.find(items[i])));
		}
	}
	
	/**
	 * Test method for {@link com.codemelon.util.MinHeap#decreaseKey()}.
	 */
	@Test
	public void testDecreaseKey() {
		// TODO
	}
}
