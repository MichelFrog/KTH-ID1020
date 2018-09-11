weimport java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doulby linked list that has a pointer at both the first and last node
 * which allows for 
 * @author michelouadria
 * @param <Element>
 *
 */
public class FIFODoublyLinkedList<Element> implements Iterable<Element> {

	private Node headNode;	//
	private Node tailNode;
	private int n;
	
	//THIS IS FOR ADDING A CHARACTER TO THE LAST NODE
	//IS IT DONE?
	public void enqueue (char c) 
	{
		//Store the current tail.
		 Node previousTailNode = tailNode;
		//Overwrite the tail with empty node.
		 tailNode = new Node();
		 tailNode.element = element;
		
		 //Empty linked list
		 if(isEmpty()) { headNode = tailNode;
			 
		 } else {
			 //Set the nextNode from the perspective of the previous to the empty node
			 previousTailNode.nextNode = tailNode;
		 }		
	}
	
	
	
	/*Used to remove the first element from the queue, following the FIFO principle.
	 * Decrement the total number of nodes.
	 * 
	 * @return recentChar The most recently extracted character*/
	public char dequeue() {
		
		char recentChar = headNode.element;
		if(isEmpty()){
			tailNode = null;
		}
		n--;
		return recentChar;
	}
	//Delete node
	//Detect Node
	
	/*Used to check if the headNode null*/
	public boolean isEmpty() {
		return headNode == null; }

	
	//return an iterator over Element as FIFO
	public Iterator<Element> iterator()
	{
		return new FIFOLinkedIterator();
	}
	
	
	
	
	private class FIFOLinkedIterator implements Iterator<Element>{

	    private Node currentNode = headNode;
		
		@Override
		public boolean hasNext() 
		{
			return currentNode != null; 		}

		@Override
		public Element next() {
		if (!hasNext()) throw new NoSuchElementException();
		Element element = currentNode.element;
        currentNode = currentNode.nextNode; 
        return element;
}
			
		
	}
}

