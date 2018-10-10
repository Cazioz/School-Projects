/* Task Two and Three
 * Written By Oscar Eklund
 * Last Edited 2018-09-29
 */
public class FrequencyCounter
{
	public static void main(String[] args)
	{
		Stopwatch timer = new Stopwatch(); //stopwatch to check time taken
		int N = 150000; // how many words to sort
		int bstkeysize = N + 1; //
		int count = 0;
		int minlen = Integer.parseInt(args[0]); // key-length cutoff
		
		// Find a key with the highest frequency count.
		
		//Binary search tree symbol table
		
		/*BST<String, Integer> bst = new BST<String, Integer>();
		while (!StdIn.isEmpty() && count <= N)
		{ // Build symbol table and count frequencies.
			count++;
			String word = StdIn.readString();
			if (word.length() < minlen) 
			{
				continue;
			} // Ignore short keys.
			if (!bst.contains(word)) 
			{
				bst.put(word, 1);
			}
			else 
			{
				bstkeysize--;
				bst.put(word, (bst.get(word) + 1)); 
			}
		}

		String[] abc = bst.keys(bstkeysize);
		String max = "";
		bst.put(max, 0);
		for(int i = 0; i < bst.size() - 1; i++) 
		{
			if (bst.get(abc[i]) > bst.get(max)) 
			{
				String newmax = abc[i];
				max = newmax;
			}
		}
		StdOut.println(max + " " + bst.get(max));	
		double time = timer.elapsedTime();
		StdOut.print("Program took " + time +"ms");*/
		
		//Binary Search in an ordered array
		
		BinarySearchST<String, Integer> st = new BinarySearchST(N);
		while (!StdIn.isEmpty() && count < N-1)
		{ // Build symbol table and count frequencies.
			count++;
			String word = StdIn.readString();
			//StdOut.print(word);
			if (word.length() < minlen) continue; // Ignore short keys.
			if (!st.contains(word)) st.put(word, 1);
			else st.put(word, st.get(word) + 1);
		}
		/*
		String max = "";
		st.put(max, 0);
		for (int i = 0; i < st.size(); i++) 
		{
			if (st.get(st.keys(i)) > st.get(max)) 
			{
				String newmax = st.keys(i);
				max = newmax;
			}
		}
		StdOut.println(max + " " + st.get(max));	
		double time = timer.elapsedTime();
		StdOut.print("Program took " + time +"ms");*/
		/*for (int i = 0; i < 100; i++) {
		StdOut.print("ab" + st.keys(i));
		}*/
		
		String[] abc =st.nMaxKeys(0, 3, st);
		for(int i = 0; i < abc.length; i++) {
			StdOut.print(abc[i] + "\n");
		}
		
		/*StdOut.print(" final:" + abc[0]);
		StdOut.print(" final:" + abc[1]);
		StdOut.print(" final:" + abc[2]);*/
		
	}
}


