package Question2;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LIFO_Stack<E> implements Iterable<E> {
    private Node<E> headNode;    
    private int N;                // size of the stack

    private static class Node<E> {
        private E data;
        private Node<E> nextNode;
    }


    public LIFO_Stack() {
    	headNode = null;
        N = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public int size() {
        return N;
    }


    public void push(E data) {
        Node<E> oldfirst = headNode;
        headNode = new Node<E>();
        headNode.data = data;
        headNode.nextNode = oldfirst;
        N++;
    }


    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        E item = headNode.data;       
        headNode = headNode.nextNode;        
        N--;
        return item;               
    }


    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return headNode.data;
    }

    
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E data : this) {
            s.append(data);
            s.append(' ');
        }
        return s.toString();
    }
       


    public Iterator<E> iterator() {
        return new ListIterator<E>(headNode);
    }

    private class ListIterator<E> implements Iterator<E> {
        private Node<E> current;

        public ListIterator(Node<E> headNode) {
            current = headNode;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.data;
            current = current.nextNode; 
            return item;
        }
    }
}