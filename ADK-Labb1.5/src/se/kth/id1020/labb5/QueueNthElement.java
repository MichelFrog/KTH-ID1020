package se.kth.id1020.labb5;
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * A doubly linked list with the option of deleting a node at the nth place.
 * The list is implemented with FIFO principle.
 * 
 * 
 * @auther michelouadria
 */
public class QueueNthElement<E> implements Iterable<E>  {

    public static void main(String[] args) {
        QueueNthElement<String> input = new QueueNthElement<>();
        input.enqueue("1");
        input.enqueue("2");
        input.enqueue("3");
        input.enqueue("4");
        input.enqueue(null);
        input.enqueue("6");

        System.out.println("Result after enqueing objects: ");
        System.out.println(input);
        input.deleteAt(5);
        System.out.println("Result after dequeing objects: ");
        System.out.println(input);

    }

    /*Class for pointers and storing input*/    
    public class Node{
        E data;              //Data for each node
        Node prevNode;       //Pointer for the previous node
        Node nextNode;       //Pointer for the next node

        /*Constructor for node.
         * @param input Vale that is inserted in the node upon creation.
         */
        public Node(E input) {
            this.data = input;
        }
    }

    /**FIELD.VAR***/
    private Node headNode;  //First node in the list
    private Node tailNode;  //Last node in the list
    private int size=0;

    boolean isEmpty() {
        return headNode == null;
    }



    /******ENQUEUE*********/
    /*Add an element at headNode*/
    public void enqueue(E newData) {
        Node newNode = new Node(newData);              //[newNode] -> [tailNode]

        if(isEmpty()) { 
            headNode = newNode;
            size++;
        }
        else { 
            newNode.nextNode = headNode;
            headNode = newNode;
            size++;
        }
    }


    /******DEQUEUE*********/
    public E dequeue(){

        E fetchedData = headNode.data;          //Grab the first element from the head node
        if(isEmpty()) {
            tailNode = null;                    //If its empty decrement the total node number
            size--;
        }
        headNode = headNode.nextNode;           //Set the headNode to nextNode, overwrite the headNode.
        return fetchedData;
    }

    public void deleteAt(int index) {
        Node currentNode = headNode;
        if(isEmpty() || index > size || index == 0) {
            System.out.println("Cant delete node at index");
            return;
        }if(index == 1) {                       //Dequeue the node if the index is one(headNode)
            dequeue();
            return;
        }
        
      /*Sets the currentNode to nextNode for each iteration
       * 
       * */
        for(int j=1; currentNode != null && j<index-1;j++) { 
            currentNode = currentNode.nextNode;
        }
        if(index > size) {//Exit if 
            return;
        }
        Node tempNode = currentNode.nextNode.nextNode;
        currentNode.nextNode = tempNode;

    }
    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        StringBuilder result = new StringBuilder();
        int counter = 1;

        while(iterator.hasNext()) {
            result.append("[");
            result.append(iterator.next());
            result.append("]");
            result.append(",");            
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }


    /******ITERATOR*********/
    public Iterator<E> iterator(){ return new ListIterator();}

    private class ListIterator implements Iterator<E>
    {
        private Node currNode = headNode;

        @Override
        public boolean hasNext() 
        {  return currNode != null;  
        }

        @Override
        public E next() {

            E data = currNode.data;
            currNode = currNode.nextNode;
            return data;
        }
        public Node getCurrentNode() {
            return currNode;
        }

    }
}

