package se.kth.id1020.labb3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList<E> implements Iterable<E> {
    public static void main(String[] args) {
        DLinkedList<String> input = new DLinkedList<>();
        input.enqueue("1991");
        input.enqueue("1010");
        input.enqueue("Hello");

        System.out.println("Result after enqueing objects: ");
        System.out.println(input);
        System.out.println("Removing: " + input.dequeue());
        System.out.println("Result after dequeing objects: ");
        System.out.println(input);

    }

    /* Class for pointers and storing input */
    public class Node {
        E data;        // Data for each node
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

    private Node headNode; // First node in the list
    private Node tailNode; // Last node in the list
    private int size;

    public boolean isEmpty() {
        return headNode == null;
    }

    /****** ENQUEUE *********/
    /* Add an element at headNode */
    public void enqueue(E newData) {
        Node newNode = new Node(newData); // [newNode] -> [tailNode]
        if(newData==null) {
            System.out.println("Can't add an element of sort Null to stack");
            return;
        }
        if (isEmpty()) {
            headNode = newNode; // [headNode]-> [newNode]
        } else {
            newNode.nextNode = headNode;
            headNode = newNode;
            size++;
        }
    }

    /****** DEQUEUE *********/
    public E dequeue() {

        E fetchedData = headNode.data; // Grab the first element from the head node
        headNode = headNode.nextNode; // Set the
        headNode.nextNode = null;

        if (isEmpty()) {
            tailNode = null; // If its empty set null, decrement the total node number
            size--;
        }
        return fetchedData;
    }

    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        StringBuilder result = new StringBuilder();

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
