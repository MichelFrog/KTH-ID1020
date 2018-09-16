package se.kth.id1020.labb2;

import java.util.List;
import java.util.Scanner;

import java.lang.IllegalArgumentException;
import java.io.*;

/**
 * The program uses a stack to add all elements from standard input from the
 * client. Each element is added with push function. A recursive function pops
 * and prints all the inputs in reverse with pop function.
 * 
 * @author michelouadria
 *
 */
public class LIFO_Stack<E> {
	private Node headNode;
	private Node nextNode;
	private int size=0;
	int stopAtLastNode = 1;

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

	/*
	 * Recursive function that keep call itself till everything has been popped and
	 * printed
	 */
	public void PopAndPrintStack() {
		
		if(stopAtLastNode == 1) {
			stopAtLastNode = size;
		}
		if (isEmpty()) {
			return;
		} else {
			if(size != stopAtLastNode) {
					System.out.print(",");
			}
			System.out.print("[");
			System.out.print(pop());
			System.out.print("]");
			PopAndPrintStack();
		}
	}

	/* Pushes an element onto the stack, unless it's null */
	void push(E element) {
		if (element == null) {
			System.out.println("Can't store null in stack");
		}
		Node newNode = new Node(element);
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
	}

	/*
	 * Fetch data from the most recently added node and remove it form stack. 
	 * Unless null
	 */
	E pop() {
		if (isEmpty()) {
			return null;
		}
		
		E fetchedElement = headNode.data;
		headNode = headNode.nextNode;
		size--;
		return fetchedElement;
	}
	
	/* @return Check if headNode contain null */
	boolean isEmpty() {
		return headNode == null;
	}

	/* @return size of stack */
	private int size() {
		return this.size;
	}

}
