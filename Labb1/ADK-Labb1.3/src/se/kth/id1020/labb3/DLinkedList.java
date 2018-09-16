package se.kth.id1020.labb3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A generic iterable doubly linked list that allows for queuing and dequeuing
 * node containing a string.  
 * 
 * @author michelouadria
 * 
 * @param <E>
 */
public class DLinkedList<E> implements Iterable<E> {
	public static void main(String[] args) {
		DLinkedList<String> input = new DLinkedList<>();
		input.enqueue("1991");
		input.enqueue("1010");
		input.enqueue("Hello");
		input.enqueue("1");
		input.enqueue("2");

		input.enqueue(null);
		System.out.println(input);
		System.out.println("Value at tail "+input.tailNode.data);
		System.out.println("Value at prev.tail "+input.tailNode.prevNode.data);
//		System.out.println(input.tailNode);
		System.out.println("Value at head " + input.headNode.data);

		System.out.println("Result after enqueing objects: ");
		System.out.println(input);
		input.dequeue();
		System.out.println("Result after dequeing objects: ");
		System.out.println(input);
		System.out.println(input.tailNode.data);
		System.out.println(input.headNode.data);

	}

	/* Class for pointers and storing input */
	public class Node {
		E data;
		Node prevNode;
		Node nextNode;

		/*
		 * Constructor for node.
		 * 
		 * @param input Vale that is inserted in the node upon creation.
		 */
		public Node(E input) {
			this.data = input;
		}

	}

	private Node headNode;
	private Node tailNode;
	private int size;

	public boolean isEmpty() {
		return headNode == null;
	}

	/****** ENQUEUE *********/
	/* Add an element at headNode */
	public void enqueue(E newData) {
		Node newNode = new Node(newData); // [newNode] -> [tailNode]
		if (newData == null) {
			System.out.println("Can't add an element of sort Null to stack");
			return;
		}
		if (isEmpty()) {
			headNode = newNode; // [headNode]-> [newNode]
			headNode.nextNode = null;
			headNode.prevNode = null;
			tailNode = headNode;
		} else {
			if(size == 0) {
				tailNode = headNode;
				tailNode.prevNode = newNode;
			}
			newNode.nextNode = headNode;
			headNode = newNode;
			size++;
		}
	}

	/****** DEQUEUE *********/
	/* Remove an element at the headNode */
	public E dequeue() {

		E fetchedData = headNode.data; // Grab the first element from the head node
		if (isEmpty()) {
			tailNode = null; // If its empty decrement the total node number
			size--;
		}
		headNode = headNode.nextNode; // Set the headNode to nextNode, overwrite the headNode.
		tailNode = headNode.nextNode;
		System.out.println("Removing: " + fetchedData);
		return fetchedData;
	}

	/*
	 * Read the linked list by iterating through and building string which will be
	 * printed.
	 */
	@Override
	public String toString() {
		Iterator<E> iterator = iterator();
		StringBuilder result = new StringBuilder();
		String emptyList;
		if (size == 0) {
			return emptyList = "Queue is empty";
		}
		while (iterator.hasNext()) {
			result.append("[");
			result.append(iterator.next());
			result.append("]");
			result.append(",");
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}

	/****** ITERATOR *********/
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		private Node currNode = headNode;

		@Override
		public boolean hasNext() {
			return currNode != null;
		}

		@Override
		public E next() {

			E data = currNode.data;
			currNode = currNode.nextNode;
			return data;
		}

	}
}
