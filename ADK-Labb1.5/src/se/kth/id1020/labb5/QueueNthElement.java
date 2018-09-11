package se.kth.id1020.labb5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A generic Iterable doubly linked list with the option of deleting a node at the nth place. It also
 * contains insert and dequeue, according to FIFO principle. The iterator is used 
 * for toString method to check if to fetch and print elements from each available node.
 * 
 * 
 * @auther michelouadria
 * 
 *  * @param <E>
 */
public class QueueNthElement<E> implements Iterable<E> {

	public static void main(String[] args) {
		QueueNthElement<String> input = new QueueNthElement<>();
		System.out.println("Insert and delete an objext at index 1: ");
		input.insert("1");
		input.deleteAt(1);
		System.out.println(input);
		
		System.out.println("Insert several input: ");
		input.insert("1");
		input.insert("2");
		input.insert("3");
		input.insert("4");
		input.insert("5");
		input.insert("6");
		System.out.println(input);

		System.out.println("Delete at index 1: ");
		input.deleteAt(1);
		System.out.println(input);
		input.insert("1");
		System.out.println("Deleting two objects at same index: ");
		input.deleteAt(6);
		input.deleteAt(6);
		System.out.println("Deleting an objects outside of index: ");
		input.deleteAt(10);
		System.out.println("Result after dequeing objects: ");
		System.out.println(input);
		input.deleteAt(1);
		System.out.println("Result after dequeing objects: ");
		System.out.println(input);

	}

	/* Class for pointers and storing input */
	public class Node {
		E data; // Data for each node
		Node prevNode; // Pointer for the previous node
		Node nextNode; // Pointer for the next node

		/*
		 * Constructor for node.
		 * 
		 * @param input Vale that is inserted in the node upon creation.
		 */
		public Node(E input) {
			this.data = input;
		}
	}

	/** FIELD.VAR ***/
	private Node headNode; // First node in the list
	private Node tailNode; // Last node in the list
	private int size = 0;

	boolean isEmpty() {
		return headNode == null;
	}

	/****** INSERT *********/
	/* Add an element at headNode */
	public void insert(E newData) {
		Node newNode = new Node(newData); // [newNode] -> [tailNode]

		if (isEmpty()) {
			headNode = newNode;
			size++;
		} else {
			newNode.nextNode = headNode;
			headNode = newNode;
			size++;
		}
	}

	/****** DEQUEUE *********/
	/*Remove an element at the headNode*/
	public E dequeue() {

		E fetchedData = headNode.data; // Grab the first element from the head node
		if (isEmpty()) {
			tailNode = null; // If its empty decrement the total node number
		}
		headNode = headNode.nextNode; // Set the headNode to nextNode, overwrite the headNode.
		size--;
		return fetchedData;
	}
	/*
	 *A method for selecting a specific node and deleting it from the queue. 
	 */
	public void deleteAt(int index) {
		Node currentNode = headNode;
		if (isEmpty() || index > size || index == 0) {
			System.out.println("Can't delete node at "+ index);
			return;
		}
		if (index == 1) { 
			dequeue();
			return;
		}

		for (int j = 1; currentNode != null && j < index - 1; j++) {
			currentNode = currentNode.nextNode;
		}
		if (index > size) {
			return;
		}
		Node tempNode = currentNode.nextNode.nextNode;
		currentNode.nextNode = tempNode;
		size--;
	}

	/*Read the linked list by iterating through and building 
	 * string which will be printed.*/
	@Override
	public String toString() {
		Iterator<E> iterator = iterator();
		StringBuilder result = new StringBuilder();
		String emptyList;

		if(size == 0) {
			return emptyList = "Queue is empty";
		}
		while (iterator.hasNext()) {
			result.append("[");
			result.append(iterator.next());
			result.append("]");
			result.append(",");
		}
		result.deleteCharAt(result.length()-1);
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

		/*Not in use*/
		public Node getCurrentNode() {
			return currNode;
		}

	}
}
