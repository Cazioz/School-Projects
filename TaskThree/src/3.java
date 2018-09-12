/* Task Three Implement a generic iterable FIFO-queue based on a double linked list.
 * Written by Oscar Eklund
 * Last edited 2018-09-07
 * Program is of a Queue implemented using a double linked list (DLL)
 * enqueue(Item) adds an Item (generic)
 * dequeue() removes an Item from queue (if queue is not empty)
 * ToString(LinkedList) transforms a queue of char into a string
 */
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>{
	
	public static void main(String[] args) { // test client
		LinkedList<Character> a = new LinkedList<Character>();
		a.enqueue('a');
		a.enqueue('b');
		a.enqueue('c');
		a.enqueue('d');
		a.enqueue('e');
		a.enqueue('f');
		a.enqueue('g');
		a.enqueue('h');
		a.dequeue();
		a.dequeue();
		Iterator<Character> iter = a.iterator(); // test iterator
		while(iter.hasNext() == true) {
			StdOut.print(iter.next());
		}
		
		StdOut.print("\n");
		
		for(int i = a.N; i > 0; i--) { // test that linkedlist is in fact double linked, using prev "pointer"
			StdOut.print(a.last.data);
			a.last = a.last.prev;
		}
		StdOut.print("\n");
		StdOut.print(ToString(a)); // tests ToString function
	}
	
	private Node first; // reference to first Node
	private Node last; // reference to last Node
	private int N = 0; // size of queue
	
	private class Node {
		Item data;
		Node next;
		Node prev;
	}
	
	public static String ToString(LinkedList<Character> list) {	// ToString function takes LinkedList and returns in String format
		String ret = "[";
		
		for(int i = 0; i < list.N; i++) { // utilizing size of queue and for loop to convert each char to string
			ret = ret + Character.toString(list.first.data) + "]"; // and then add to a string which
			if(i != list.N - 1) {ret = ret +",[";}
			list.first = list.first.next;  					 // is then returned
		}	
		
		return ret;
	}
	
	public void enqueue(Item in) { // function for adding items in queue
		
		Node oldlast = last; // save old last and creates a new last
		last = new Node();
		last.data = in; // sets value of new last 
		last.next = null; // sets next pointer to null since last is last in queue
		if(first == null) { // if first == null means queue is empty, as such when
			first = last; // an element is added it will be both first and last
			first.prev = null;
		}
		else {
			oldlast.next = last;
			last.prev = oldlast;
		}
		N++;
	}
	
	public Item dequeue() { // removes an item from queue
		Item ret = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		N--;
		return ret;
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item> {
	
		private Node current = first;
		
		public boolean hasNext()
		{ return current != null; }
		

		public void remove() { }
		
		public Item next()
		{
			Item item = current.data;
			current = current.next;
			return item;
		}
	} 
}
