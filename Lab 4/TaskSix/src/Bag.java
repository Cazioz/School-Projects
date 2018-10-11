/* Task Six
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * Implemented using code from book with only slight changes
*/
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first; // first node in list
	private class Node
	{
		 Item item;
		 Node next;
	}
	
	public void add(Item item)
	{ // same as push() in Stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}
		else return false;
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{ return current != null; }
	
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	} 
}
