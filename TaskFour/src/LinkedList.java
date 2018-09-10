/* Task Four Implement a generic iterable circular linked list which allows the user to insert and remove
 * elements to/from the front and back end of the queue. Be careful when designing the API.
 * Written by Oscar Eklund
 * Last edited 2018-09-07
 * Program is of a Circular queue
 * addfirst(Item) adds an Item to the end of the queue (generic)
 * removefirst() removes an Item from the beginning of the queue 
 * addlast(Item) adds an Item at the end of the queue
 * removelast() removes an Item from the end of the queue
 * ToString(LinkedList) transforms a queue of char into a string
 */
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>{
	
	public static void main(String[] args) { // test client
		LinkedList<Character> a = new LinkedList<Character>();
		a.addlast('a');
		a.addlast('b');
		a.addlast('c');
		a.addfirst('1');
		a.addfirst('2');
		a.addlast('d');
		a.addlast('e');
		a.addlast('f');
		a.addlast('g');
		a.addlast('h');
		a.removelast();
		a.removelast();
		
		Iterator<Character> iter = a.iterator(); // test iterator (implement count since queue is circular
		int count = 0;							 // which would result in an infinite loop otherwise)
		while(iter.hasNext() == true && count < 20) {
			StdOut.print(iter.next());
			count++;
		}	

		StdOut.print(ToString(a)); // tests ToString function 
		
	}
	
	private Node first; // reference to first Node
	private Node last; // reference to last Node
	private int N = 0; // size of queue
	
	private class Node {
		Item data;
		Node next;
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
	
	public void addfirst(Item in) {
		
		Node oldfirst = first;
		first = new Node();
		first.data = in;
		if(first == null) { // if first == null means queue is empty, as such when
			first = last; // an element is added it will be both first and last
		}
		else {
			last.next = first;
		}
		first.next = oldfirst;
		N++;
	}
	
	public void addlast(Item in) { // function for adding items in the end of the queue
		
		Node oldlast = last; // save old last and creates a new last
		last = new Node();
		last.data = in; // sets value of new last 
		if(first == null) { // if first == null means queue is empty, as such when
			first = last; // an element is added it will be both first and last
		}
		else {
			oldlast.next = last;
		}
		last.next = first; // setting last.next = first is what makes queue circular
		N++;
	}
	
	public Item removefirst() { // removes an item from the beginning of the queue

		Item ret = first.data;
		first = first.next;
		last.next = first;
		if(first == null) {
			last = null;
		}
		N--;
		return ret;
	}
	
	public Item removelast() { // removes an item from the end of the queue
		for(int i = 0; i < N - 1; i++) {
			last = last.next;
		}
		Item ret = last.data;
		last.next = first;
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
