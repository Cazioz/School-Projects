/* Task Five Implement a generalized queue which allows the user to remove the 
 * kth element from the queue. Assume the most recently added element has index 1.
 * Written by Oscar Eklund
 * Last edited 2018-09-07
 * ToString(LinkedList) transforms a queue of char into a string
 */
public class LinkedList {
	
	public static void main(String[] args) {
		LinkedList test = new LinkedList(5);
		test.add('a');
		test.add('b');
		test.add('c');
		StdOut.print(test.returnvalue(0));
		StdOut.print(test.returnvalue(1));
		StdOut.print(test.returnvalue(2));
		StdOut.print(test.returnvalue(3));
	}
	
	private char[] a;
	private int N;
	
	public LinkedList(int size) {
		a = new char[size];
	}
	
	public char returnvalue(int pos) {
		return a[pos];
	}
	
	public void add(char c) {
		for(int i = N; i > 1; i--) {
			a[i + 1] = a[i]; 
		}
		a[1] = c;
	}
	
}
