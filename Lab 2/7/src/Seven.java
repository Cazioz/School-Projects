/* Task Seven
* Written by Oscar Eklund
* Last edited 2018-09-17
* enqueue(int a) puts an int into the linked list in ascending order.
* dequeue() removes an int from the linked list first position.
*/
public class Seven {
	
	public static void main(String[] args) {
		Seven list = new Seven();
		list.enqueue(5);
		list.enqueue(6);
		list.enqueue(4);
		list.enqueue(3);
		list.enqueue(7);
		list.enqueue(-5);
		list.enqueue(-3);
		list.enqueue(-7);
		list.dequeue();
		list.dequeue();
		StdOut.print(ToString(list));
	}
		
		private Node first; // reference to first Node
		private Node last; // reference to last Node
		private int N = 0; // size of queue
		
		private class Node {
			int data;
			Node next;
		}
		
		public void enqueue(int a) { // queues an item with respect to its value (rather than just putting it in last position of queue)
			Node newNode = new Node();
			newNode.data = a;
			if(N == 0) { // if linked list is empty put element at position first
				first = newNode;
				last = first;
				first.next = null;
				last.next = null;
				first.data = a;
				N++;
			}
			else { // if not empty then do a loop to check where to position value
				Node temp = first;
				int count = 0;
				while(temp != null) { // loop through entire list
					if((temp.data <= a) && ((temp.next == null) || temp.next.data >= a)) {
						newNode.next = temp.next; // if previous value is <= and next value is >= means we found a place to place value
						temp.next = newNode;
						N++;
						break;
					}
					else if((temp.data > a) && (count == 0)) { // if first value is larger than new value we create a new first
						newNode.next = first;
						first = newNode;
						N++;
						break;
					}
					else { // else loop through to next position.
						temp = temp.next;
					}
					count++;
				}	
			}
		}
		
		public int dequeue() { // removes an item from queue
			int ret = first.data;
			first = first.next;
			if(first == null) {
				last = null;
			}
			N--;
			return ret;
		}
	
	
	public static String ToString(Seven list) {	// ToString function takes LinkedList and returns in String format
		String ret = "[";
		for(int i = 0; i < list.N; i++) { // utilizing size of queue and for loop to convert each char to string
			ret = ret + Integer.toString(list.first.data) + "]"; // and then add to a string which
			if(i != list.N - 1) {ret = ret +",[";}
			list.first = list.first.next;  					 // is then returned
		}	
		
		return ret;
	}
}
