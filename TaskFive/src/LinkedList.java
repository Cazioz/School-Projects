/* Task Five Implement a generalized queue which allows the user to remove the 
 * kth element from the queue. Assume the most recently added element has index 1.
 * Written by Oscar Eklund
 * Last edited 2018-09-08
 * ToString(LinkedList) transforms a queue (array) of char into a string
 * dequeue(int pos) removes a char from position pos of the queue and returns char
 * enqueue(char c) adds a char to the end of the queue 
 */
public class LinkedList {
	
	public static void main(String[] args) { // tests all functions of LinkedList (queue)
		LinkedList test = new LinkedList(7);
		test.enqueue('a');
		test.enqueue('b');
		test.enqueue('c');
		test.enqueue('d');
		test.enqueue('e');
		test.dequeue(3);
		StdOut.print(isEmpty());
		StdOut.print("\n");
		StdOut.print(test.ToString());
		/*
		StdOut.print(test.returnvalue(1));
		StdOut.print(test.returnvalue(2));
		StdOut.print(test.returnvalue(3));
		StdOut.print(test.returnvalue(4));
		StdOut.print(test.returnvalue(5));
		*/
	}
	
	private static char[] a;
	private static int N = 1;
	
	public LinkedList(int size) {
		a = new char[size];
	}
	
	public static String ToString() { // returns string representation of queue
		String ret = "[";
		for(int i = 1; i < N; i++) {
			ret = ret + a[i] + "]";
			if(i < N-1) {ret = ret + ",[";}
		}
		return ret;
	}
	
	/*
	public char returnvalue(int pos) {
		return a[pos];
	}
	*/
	
	public static boolean isEmpty() {
		if(N == 1) {return true;}
		else {return false;}
	}
	
	/*
	public int returnsize() {
		return (N - 1);
	}
	*/
	
	public void enqueue(char c) { // adds a char to the end of the queue
		for(int i = N; i >= 1; i--) {
			a[i + 1] = a[i]; 
		}
		a[1] = c;
		N++;
	}
	
	public char dequeue(int pos) { // removes a char from position pos of the queue and returns char
		if(pos < N) {  // checks whether element at pos exists
		char ret = a[pos];
		for(int i = pos; i < N; i++) { // moves all elements after pos "down one position" in index
			a[i] = a[i + 1];
		}
		N--;
		return ret;
		}
		else {
			StdOut.print("Index out of bound, no such element exists");
			return '\0';
		}
	}
	
}
