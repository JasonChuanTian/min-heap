package com.codemelon.util;

/**
 * Test class for MinHeap
 * @author Marshall Farrier
 * @since Sep 24, 2013
 */
public class Node implements Comparable<Node> {
	private int name;
	private int weight;
	
	public Node(int name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public int getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Node)) 
			return false;
		Node node = (Node) o;
		return this.name == node.name && this.weight == node.weight;
	}
	
	@Override
	public int hashCode() {
		return 23 * name + weight;
	}

	/**
	 * Note: This class has a natural ordering that is inconsistent
	 * with equals
	 */
	@Override
	public int compareTo(Node node) {
		return this.weight - node.weight;
	}

}
