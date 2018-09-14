import java.util.Scanner;

public class Three {
public static void main(String[] args) { //test client
		
		Scanner input = new Scanner(System.in); // utilizing scanner for input of integers for array
		StdOut.print("Please enter size of array: ");
		int size = StdIn.readInt(); // size of array
		int revarr[] = new int[size];
		if(size <= 0) { // just to be safe if the user is a bit stupid..
			StdOut.print("\n" + "That's an invalid size."); 
			throw new NegativeArraySizeException();
		}
		
		else { 
			StdOut.print("\n" + "Please enter integers separated by spaces: "); // create an array from user input 
			int[] array = new int[size];
			
			for(int i = 0; i < size; i++) {
				array[i] = input.nextInt(); // using scanner inside a for loop
			}
			
			revarr = sort(array); // Task Two code to reverse array, simple for loop exchanging last value with first value
			int end = size - 1; // and then increment so first value is second value etc..
			for(int i = 0; i < end; i++) {
				int temp = revarr[i]; // temp value so no value is lost
				revarr[i] = revarr[end];
				revarr[end] = temp;
				end--;
			}
			StdOut.print(toString(revarr));
		}		
	} 
	
	public static int[] sort(int[] a) { // argument is array that you want sorted
		int swapCount = 0;  // Task Three counter for number of swaps
		for(int i = 0; i < a.length; i++) { // outer loop is for exchanging variables found in inner loop
			int min = i; // initial value, may change if a[i] is not smallest int
				
			for(int j = i + 1; j < a.length; j++ ) { // inner loop for finding smallest int
				if(a[j] < a[min]) {
					min = j; // once a smaller int has been found set min = j and continue loop until j is = a.length
				}	
			}
			if(a[i] > a[min]) { // only necessary to do an exchange if new min is actually smaller
				int ex = a[i]; // exchange positions of smallest int and a[i]
				a[i] = a[min];
				a[min] = ex;
				StdOut.print(toString(a)); // prints string representation of array
				StdOut.print("\n");
				swapCount++; // if a swap was done increment swapCount
			}
		}
		StdOut.print("Number of swaps was: " + swapCount + "\n");
		return a;
	}
	public static String toString(int[] b) { // simple array to string function
		String c = "";
		for(int i = 0; i < b.length; i++) { // for loop that adds every int to the string and then
			c = c + b[i];                   // separates them with a comma
			if (i < b.length - 1) {         // if last int then don't add a comma (would otherwise end with a comma)
				c = c + ",";
			}
		}
		return c;
	}
}
