import java.util.Scanner;

public class One {
	public static void main(String[] args) { //test client
		Scanner input = new Scanner(System.in); // utilzing scanner for input of integers for array
		StdOut.print("Please enter size of array: ");
		int size = StdIn.readInt(); // size of array
		
		if(size <= 0) { 
			StdOut.print("\n" + "That's an invalid size."); 
			throw new NegativeArraySizeException();
		}
		
		else { 
			StdOut.print("\n" + "Please enter integers separated by spaces: ");
			int[] array = new int[size];
			for(int i = 0; i < size; i++) {
			array[i] = input.nextInt();
			}
		sort(array);
		}
		
	} 
	
		public static void sort(int[] a) { // argument is array that you want sorted
			for(int i = 0; i < a.length; i++) { // outer loop is for exchanging variables found in inner loop
				int min = i; // initial value, may change if a[i] is not smallest int
				
				for(int j = i + 1; j < a.length; j++ ) { // inner loop for finding smallest int
					if(a[j] < a[min]) {
						min = j; // once a smaller int has been found set min = j and continue loop until j is = a.length
					}
					
					
					
				}
				int ex = a[i]; // exchange positions of smallest int and a[i]
				a[i] = a[min];
				a[min] = ex;
				StdOut.print(toString(a)); // prints string representation of array
				StdOut.print("\n");
			}
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


