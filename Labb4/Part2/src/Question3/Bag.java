package Question3;
import java.util.Iterator;

/**
 * @author michelouadria
 *
 * @param <E>
 */
public class Bag<E> implements Iterable<E> {
	private Node first; 

	private class Node {
		E element;
		Node nextNode;
	}

	public void add(E element) { 
		Node oldfirst = first;
		first = new Node();
		first.element = element;
		first.nextNode = oldfirst;
	}

	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		private Node currentNode = first;

		public boolean hasNext() {
			return currentNode != null;
		}

		public E next() {
			E element = currentNode.element;
			currentNode = currentNode.nextNode;
			return element;
		}
	}
}