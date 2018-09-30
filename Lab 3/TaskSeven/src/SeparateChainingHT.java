
public class SeparateChainingHT<Key, Value> {
	
	public SeparateChainingHT(int M) // creates an array (size M) of ordered arrays (binary search)
	{
		this.M = M; //size of this hash table
		st = (BinarySearchST<String, Integer>[]) new BinarySearchST[M]; 
		for(int i = 0; i < M; i++) 
		{
			st[i] = new BinarySearchST<String, Integer>(250); 
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
