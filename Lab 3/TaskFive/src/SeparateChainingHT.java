
public class SeparateChainingHT<Key, Value> {
	
	public static void main(String[] args) {
		SeparateChainingHT<String, Integer> st = new SeparateChainingHT<String, Integer>(97);
		/*StdOut.print(st.hash("abc"));
		StdOut.print(st.hash("12345"));*/
		/*st.put("abc", 2);
		st.put("abcd", 2);
		st.put("1234", 3);
		StdOut.print(st.hash("1234"));
		StdOut.print(st.get("abc"));
		StdOut.print(st.get("1234"));
		System.out.print(st.contains("1234"));
		StdOut.print(st.ab(2));*/
		int count = 0;
		int minlen = Integer.parseInt(args[0]);
		int N = 3000000;
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
			StdOut.print(st.ab(i) + " ");
		}
	}
	
	private int M; // size of hash table
	private BinarySearchST<String, Integer>[] st;
	
	public boolean contains(String word) {
		if(st[hash(word)].get(word) != null) 
		{
			return true;
		}
		else return false;
	}
	
	public SeparateChainingHT(int M) 
	{
		this.M = M; //size of this hash table
		 st = (BinarySearchST<String, Integer>[]) new BinarySearchST[M]; // creates an array of Binary Search Symbol Trees
		for(int i = 0; i < M; i++) 
		{
			st[i] = new BinarySearchST<String, Integer>(250); // Creates symbol trees in each array index
		}
	}
	
	private int hash(String key) 
	{
		int ret;
		ret = (key.hashCode() & 0x7fffffff) % M; // masks off sign bit and returns remainder when dividing by hash table size (M)
		return ret;
	}
	
	public int ab(int pos) {
		return st[pos].size();
	}
	
	 public int get(String key) // Using string since I know it will be a string input (Tale of Two Cities)
	 { 
		 return st[hash(key)].get(key); 
	 }
	 
	 public void put(String key, Integer val)
	 { 
		 st[hash(key)].put(key, val); 
	 }
}
