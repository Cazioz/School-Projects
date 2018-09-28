/* Task Two
 * Written By Oscar Eklund
 * Last Edited 2018-09-28
 * Implemented using Binary Search Tree Symbol Table
 * Test using FrequenceCounter yielded results:
 * size() returns amount of elements in symbol tree
 * min() returns min key
 * max() returns max key
 * keys() returns Key[] with all keys
 * keys(int) returns String[] of size int with min keys to int
 * get(Key) returns Key's value pair
 * put(Key, Value) adds Key-Value pair to array, if Key already exists in array only updates Value
 * contains(Key) determines whether key is in array
 * N = 100, time taken by an average of 10 tests: 0.029ms, word "of"
 * N = 200, time taken by an average of 10 tests: 0.031ms, word "Chapter"
 * N = 400, time taken by an average of 10 tests: 0.033ms, word "Chapter"
 * N = 800, time taken by an average of 10 tests: 0.035ms, word "the"
 * N = 2000, time taken by an average of 10 tests: 0.041ms, word "the"
 * N = 10000, time taken by an average of 10 tests: 0.063ms, word "the"
 */
public class BST<Key extends Comparable<Key>, Value>
{
	public static void main(String[] args) {
		BST<String, Integer> bst = new BST<String, Integer>();
		bst.put("abc", 1);
		bst.put("abcd", 4);
		bst.put("abcdef", 2);
		bst.put("abcdefg", 31);
		bst.put("abcdefgh", 1);
		
		String[] abc = bst.keys(5);
		StdOut.print("max : " + bst.max());
		StdOut.print("min : " + bst.min());
		//StdOut.print(abc.length);
		for(int i = 0; i < abc.length; i++) {
		StdOut.print(abc[i] + " ");
		}
		
	}
	private Node root; // root of BST
	private class Node
	{
		private Key key; // key
		private Value val; // associated value
		private Node left, right; // links to subtrees
		private int N; // # nodes in subtree rooted here
		
		public Node(Key key, Value val, int N)
		{ this.key = key; this.val = val; this.N = N; }
	}
	public int size()
	{ return size(root); }
	
	private int size(Node x)
	{
		if (x == null) return 0;
		else return x.N;
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		if (x.left == null) return x;
		return min(x.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node x)
	{
		if (x.right == null) return x;
		return max(x.right);
	}
	
	public String[] keys(int size)
	{ return keys(min(), max(), size); }
	
	public String[] keys(Key lo, Key hi, int size)
	{
		String[] queue = new String[size];
		keys(root, queue, lo, hi);
		return queue;
	}
	
	public int count = 0;
	
	private void keys(Node x, String[] queue, Key lo, Key hi)
	{
		
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
			}
		if (cmplo <= 0 && cmphi >= 0 && count < queue.length) 
		{
			//StdOut.print("adding " + x.key + " to count = " + count);
			
			queue[count]=(String) (x.key);
			count++;
			
		}
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
	

	public Value get(Key key)
	{ return get(root, key); }
	
	private Value get(Node x, Key key)
	{ // Return value associated with key in the subtree rooted at x;
		// return null if key not present in subtree rooted at x.
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}
	
	public void put(Key key, Value val)
	{ // Search for key. Update value if found; grow table if new.
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val)
	{
		// Change key’s value to val if key in subtree rooted at x.
		// Otherwise, add new node to subtree associating key with val.
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
	 	if (cmp < 0) x.left = put(x.left, key, val);
	 	else if (cmp > 0) x.right = put(x.right, key, val);
	 	else x.val = val;
	 	x.N = size(x.left) + size(x.right) + 1;
	 	return x;
	}
	
	public boolean contains(Key key) {
		if(get(key) != null) {
			return true;
		}
		else return false;
	}
	
}
