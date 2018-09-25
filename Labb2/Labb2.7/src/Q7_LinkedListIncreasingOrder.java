import java.util.Iterator;

/**
 * Singly linked list that sorts the list in ascending order by always ordering
 * each element when they are added to correct position
 * 
 * @author michelouadria
 *
 */
public class Q7_LinkedListIncreasingOrder {
    public static void main(String[] args) {
        Q7_LinkedListIncreasingOrder input = new Q7_LinkedListIncreasingOrder();
        input.enqueue(1);
        input.enqueue(2);
        input.enqueue(4);
        input.enqueue(-3);
        input.enqueue(3);
        input.enqueue(5);
        input.enqueue(0);

    }

    /* Class for pointers and storing input */
    public class Node {
        int data;
        Node nextNode;

        /*
         * Constructor for node.
         * 
         * @param input Vale that is inserted in the node upon creation.
         */
        public Node(int input) {
            this.data = input;
        }

    }

    private Node headNode;
    private int size = 0;

    public boolean isEmpty() {
        return headNode == null;
    }

    /****** ENQUEUE *********/
    /* Add an element at headNode */
    public void enqueue(int newData) {
        Node newNode = new Node(newData);
        Node current = headNode;
        if (isEmpty()) {/*If null create first node*/
            headNode = newNode;
        } else if (newNode.data < headNode.data) { //If less, set before head, head becomes next
            newNode.nextNode = headNode;
            headNode = newNode;
        } else {
            while (current.nextNode != null && newNode.data > current.nextNode.data) { //As long as the next isn't null keep going and check if still larger
                current = current.nextNode;
            }
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }
        size++;
        print();
    }

    /*
     * Read the linked list by iterating through and building string which will be
     * printed.
     */
    public void print() {
        Node currentNode = headNode;
        int i = size;
        if (size == 0) {
            return;
        }
        while (i > 0 && currentNode != null) {
            System.out.print("[");
            System.out.print(currentNode.data);
            System.out.print("]");
            System.out.print(",");
            currentNode = currentNode.nextNode;
            i++;
        }
        System.out.println();
    }
    

    }


