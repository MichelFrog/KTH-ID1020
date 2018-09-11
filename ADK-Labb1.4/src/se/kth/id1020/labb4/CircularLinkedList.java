package se.kth.id1020.labb4;
import java.util.Iterator;

import DLinkedList.ListIterator;
import DLinkedList.Node;

/*
 * This program implements a genereic iterable circular doubly linked list
 * with the following features:
 * -Insertion of an integer from the front & back
 * -Deletion of an integer from the front or back
 *
 * @author michelouadria
 *
 * @param <E>
 */
public class CircularLinkedList<E> implements Iterator<E> {

    public static void main(String[] args) {
        CircularLinkedList<String> input = new CircularLinkedList<>();
        input.enqueueAfterHead("1991");
        input.enqueueAfterHead("1001");
        input.enqueueAfterHead("1984");
        input.enqueueAfterTail("1");
        input.enqueueAfterTail("Hello");
        input.enqueueAfterHead("1984");

        System.out.println(input);
        input.dequeueAtHead();
        System.out.println(input);
        input.dequeueAtTail();
        System.out.println(input);

    }

    // private Node tempNode;
    private Node tailNode;
    private Node headNode;
    private int size;

    /***** NODE CLASS ***/
    private class Node {
        private Node nextNode;
        private Node prevNode;
        private E data;

        // Used for creating a node object
        // with an element inside it
        public Node(E data) {
            this.data = data;
        }
    }

    private boolean isEmpty() {
        return headNode == null;
    }

    /****** ENQUEUE *********/
    /* Add an element after TAIL */
    public void enqueueAfterTail(E newData) {
        Node newNode = new Node(newData);

        if (isEmpty()) {
            createNewNodeValuesForHeadAndTail(newNode);
        } else {
            newNode.prevNode = tailNode;
            tailNode.nextNode = newNode;
            headNode.prevNode = newNode;
            newNode.nextNode = headNode;
            tailNode = newNode;
        }
        size++;
    }

    /* Add an element at HEAD */
    public void enqueueAfterHead(E newData) {
        Node newNode = new Node(newData);
        newNode.nextNode = headNode; // [newNode]-> [headNode]
        if (isEmpty()) {
            createNewNodeValuesForHeadAndTail(newNode);
        } else {
            newNode.prevNode = tailNode;
            tailNode.nextNode = newNode;
            headNode.prevNode = newNode;
            newNode.nextNode = headNode;
            headNode = newNode;
        }
        size++;
    }

    /****** DEQUEUE *********/

    /* Remove node from head 
     * The headNode gets deleted and the next node is put in place of it.
     */
    public void dequeueAtHead() {
        Node tempNode;
        if (isEmpty()) {
            tailNode = null; // If its empty decrement the total node number
            headNode = null;
            size--;
        }
        System.out.println("Deleting at Head: " + headNode.data);
        tempNode = headNode.nextNode;
        headNode.prevNode = null;
        headNode.nextNode = null;
        tempNode.prevNode = tailNode;
        tailNode.nextNode = tempNode;
        headNode = tempNode;

        size--;

    }

    /*
     * Remove node from head
     * 
     * The tailNode gets deleted and the previous node is put in place of it.
     */
    public void dequeueAtTail() {
        Node tempNode;

        if (isEmpty()) {
            headNode = null;
            tailNode = null;
        } else
            System.out.println("Deleting from tail: " + tailNode.data);
        tempNode = tailNode.prevNode;
        tailNode.prevNode = null;
        tailNode.nextNode = null;
        tempNode.nextNode = headNode;
        headNode.prevNode = tempNode;
        tailNode = tempNode;
        size--;
    }
    
    private void createNewNodeValuesForHeadAndTail(Node newNode) {
        newNode.nextNode = newNode; //
        newNode.prevNode = newNode;
        headNode = newNode; // [headNode]-> [newNode]
        tailNode = headNode; // Only one node in the list
    }

    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        StringBuilder result = new StringBuilder();
        int countToSize = 0;

        result.append("[");
        while (iterator.hasNext() && countToSize < size) {
            result.append("[");
            result.append(iterator.next());
            result.append("]");
            result.append(",");
            countToSize++;
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

        /*
         * Check if the current node in the linked isn't null.
         * 
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        /*
         * @return The generic item is returned.
         */
        @Override
        public E next() {

            E data = currNode.data;
            currNode = currNode.nextNode;
            return data;
        }
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return null;
    }

}
