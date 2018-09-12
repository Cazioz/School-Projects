/* Task Two Implement the above program in JAVA using one of the ADTs suggested in ch. 1.3
 * Written by Oscar Eklund
 * Last edited 2018-09-10
 * Stack(int) creates a new Stack of size int
 * push(char) adds an element to the highest index
 * pop() removes an element from the highest index
 * isEmpty() checks whether stack is empty
 * size() checks amount of chars in array (on stack)
 * Explanation: I've implemented the program using a stack, i push chars onto the stack and then pop them
 * Since stacks are LIFO this means the input will be reversed.
 */
public class Stack {
	
		private char a[]; // instance variable form of array
		private int s = 0; // number of items in the stack
		
		public Stack(int capacity) { // create a new object Stack 
			a = new char[capacity]; // which is just an array of chars
		}
		
		public void push(char in) { // add element to highest index
			a[s] = in;
			s++;
		}
		public char pop() { // remove element from the highest index
			s--;
			return a[(s)];
		}
		
		public boolean isEmpty() { // check whether size (items in stack) == 0
			if(s == 0) { return true; } // aka if array is empty
			else { return false; }
		}
		
		public int size() { // check amount of chars in array
			return s - 1;
		}
		
		// test client which tests all functions of Stack
		public static void main(String[] args) {
			Stack ReverseStack = new Stack(100); // Creates a new object Stack
			while(true) {
				char a = StdIn.readChar();
				if(a != '\n') { // if new line is detected, stop
					ReverseStack.push(a); // if new line was not detected, insert char into Stack
				}
				else { break; }
			}
			if(ReverseStack.isEmpty() == false) { StdOut.print("Stack is not empty \n"); } // test of isEmpty function
			StdOut.print("Size of Stack is: " + ReverseStack.size() + "\n");
			
			for(int i = ReverseStack.size(); i >= 0; i--) { // Print out in reverse order, highest index -> lowest
				StdOut.print(ReverseStack.pop());
			}
		}
}
