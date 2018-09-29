/* Task Two
 * Written By Oscar Eklund
 * Last Edited 2018-09-29
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
	
	//Node (like the concept of linked list) used to created symbol tree
	private class Node
	{
		private Key key; 
		private Value val; 
		private Node left, right; 
		private int N; 
		
		public Node(Key key, Value val, int N)
		{ this.key = key; this.val = val; this.N = N; }
	}
	
	//function that returns size of symbol tree
	public int size()
	{ return size(root); }
	
	private int size(Node x)
	{
		if (x == null) return 0;
		else return x.N; // N is # of nodes in symbol tree
	}
	
	//returns min key 
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x) //traverses to the left until reaching x.left == null and returns that element
	{
		if (x.left == null) return x;
		return min(x.left);
	}
	
	//returns max key
	public Key max()
	{
		return max(root).key;
	}
	
	//like min except it traverses to the right
	private Node max(Node x)
	{
		if (x.right == null) return x;
		return max(x.right);
	}
	
	//returns all keys 0....size using method overloading
	public String[] keys(int size)
	{ return keys(min(), max(), size); }
	
	//returns String[] representation of symbol tree
	public String[] keys(Key lo, Key hi, int size) 
	{
		String[] queue = new String[size];
		keys(root, queue, lo, hi);
		return queue;
	}
	
	public int count = 0; //helper variable to decide position in String[] queue
	
	private void keys(Node x, String[] queue, Key lo, Key hi)
	{
		if (x == null) return; // if x is empty(null)
		int cmplo = lo.compareTo(x.key); 
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) { //if lo < x.key
			keys(x.left, queue, lo, hi); //recursive call to find all values to the left of lo
		}
		if (cmplo <= 0 && cmphi >= 0 && count < queue.length) //if key is between min and low and count is not larger than queue.length
		{
			//StdOut.print("adding " + x.key + " to count = " + count);
			queue[count]=(String) (x.key); //adds x.key to String[]
			count++;
		}
		if (cmphi > 0) keys(x.right, queue, lo, hi); //if x.key > max (which it really shouldn't ever be)
	}
	
	//returns Value of Key
	public Value get(Key key)
	{ return get(root, key); }
	
	private Value get(Node x, Key key)
	{ 
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(x.left, key); // recursive functions to ensure correct key is selected
		else if (cmp > 0) return get(x.right, key);
		else return x.val; // and then Value is returned
	}
	
	//adds key to symbol tree if it is not already in tree, if so then updates Value
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val)
	{
		if (x == null) return new Node(key, val, 1); // if node is an empty node (aka if symbol tree is empty since it is called using root)
		int cmp = key.compareTo(x.key);
	 	if (cmp < 0) x.left = put(x.left, key, val); // ensures correct position according to binary symbol tree
	 	else if (cmp > 0) x.right = put(x.right, key, val); // ensures correct position according to binary symbol tree
	 	else x.val = val; // updates value of x
	 	x.N = size(x.left) + size(x.right) + 1; // updates size of symbol tree
	 	return x;
	}

	//simple function to check whether symbol tree contains Key
	public boolean contains(Key key) {
		if(get(key) != null) {
			return true;
		}
		else return false;
	}
	
}
