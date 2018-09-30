/* Task Five
 * Written By Oscar Eklund
 * Last Edited 2018-09-30
 * Creates a hash table of ordered arrays (binary search) 
 * and prints out sizes of all ordered arrays
 */
public class SeparateChainingHT<Key, Value> {
	
	public static void main(String[] args) {
		SeparateChainingHT<String, Integer> st = new SeparateChainingHT<String, Integer>(97);
		/*StdOut.print(st.hash("abc"));
		StdOut.print(st.hash("12345"));
		st.put("abc", 2);
		st.put("abcd", 2);
		st.put("1234", 3);
		StdOut.print(st.hash("1234"));
		StdOut.print(st.get("abc"));
		StdOut.print(st.get("1234"));
		System.out.print(st.contains("1234"));
		StdOut.print(st.contains(2));*/
		int count = 0;
		int minlen = Integer.parseInt(args[0]);
		int N = 140000;
		while (!StdIn.isEmpty() && count < N-1)
		{ // Build symbol table and count frequencies.
			count++;
			String word = StdIn.readString();
			//StdOut.print(word);
			if (word.length() < minlen) continue; // Ignore short keys.
			if (!st.contains(word)) st.put(word, 1);
			// else st.put(word, st.get(word) + 1);
		}
		for(int i = 0; i < 97; i++){
			StdOut.print(st.size(i) + " ");
		}
	}
	
	private int M; // size of hash table
	private BinarySearchST<String, Integer>[] st;
	
	public SeparateChainingHT(int M) // creates an array (size M) of ordered arrays (binary search)
	{
		this.M = M; //size of this hash table
		st = (BinarySearchST<String, Integer>[]) new BinarySearchST[M]; 
		for(int i = 0; i < M; i++) 
		{
			st[i] = new BinarySearchST<String, Integer>(250); // M > key-value pairs
		}
	}
	
	public boolean contains(String word) { // if symbol tree at st[] contains word returns true
		if(st[hash(word)].get(word) != null) 
		{
			return true;
		}
		else return false;
	}
	
	
	private int hash(String key) // uses javas built in hashCode() for string and then calculates index
	{
		int ret;
		ret = (key.hashCode() & 0x7fffffff) % M; // masks off sign bit and returns remainder when dividing by hash table size (M)
		return ret;
	}
	
	public int size(int pos) { // size of symbol tree at pos (used to determine how evenly distributed hashes are)
		return st[pos].size();
	}
	
	 public int get(String key) // Using string since I know it will be a string input (Tale of Two Cities)
	 {  // gets value of word in symbol tree
		 return st[hash(key)].get(key); 
	 }
	 
	 public void put(String key, Integer val) //adds String-Integer pair to array symbol tree
	 { 
		 st[hash(key)].put(key, val); 
	 }
	 
}
