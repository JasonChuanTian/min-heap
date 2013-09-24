/**
 * 
 */
package com.codemelon.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#clear()}.
	 */
	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#comparator()}.
	 */
	@Test
	public void testComparator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#offer(java.lang.Object)}.
	 */
	@Test
	public void testOffer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#peek()}.
	 */
	@Test
	public void testPeek() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#poll()}.
	 */
	@Test
	public void testPoll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.codemelon.util.MinHeap#iterator()}.
	 */
	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
