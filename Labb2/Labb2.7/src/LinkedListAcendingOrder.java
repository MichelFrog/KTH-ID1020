import java.util.Iterator;

public class LinkedListAcendingOrder<E> implements Iterator<E> {

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
    /* Queue an element at the tailNode's position */
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

    /* Queue an element at the headNode's position */
  

    /****** DEQUEUE *********/

    /*
     * Remove node from head The headNode gets deleted and the next node is put in
     * place of it.
     */
    public void dequeueAtHead() {
        Node tempNode;
        if (isEmpty()) {
            tailNode = null;
            headNode = null;
            size = 0;
            return;
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


    /* Setting up a new node that will point to itself and becomes the object 
     * which the headNode and tailNode points to */
    private void createNewNodeValuesForHeadAndTail(Node newNode) {
        newNode.nextNode = newNode;
        newNode.prevNode = newNode;
        headNode = newNode; // [headNode]-> [newNode]
        tailNode = headNode; // Only one node in the list
    }
    
    /*Read the linked list by iterating through and building 
     * string which will be printed.*/
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
