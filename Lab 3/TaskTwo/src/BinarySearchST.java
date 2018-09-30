/* Task Two and Three
 * Written By Oscar Eklund
 * Last Edited 2018-09-29
 * Implemented using Binary Search in an ordered array
 * keys() returns Key[] with all keys
 * keys(int) returns key at keys[int]
 * keys(key lo, key hi) returns all keys between key lo and key hi
 * BinarySearchST(int) constructor creates a new Binary Search array
 * rank(Key) determines rank of Key, or in other words, how many keys are under Key
 * size() returns amount of elements in array
 * get(Key) returns Key's value pair
 * put(Key, Value) adds Key-Value pair to array, if Key already exists in array only updates Value
 * contains(Key) determines whether key is in array
 * nMaxKeys(int n, int nxth, BinarySearchST<String, Integer> st) returns n to nxth most frequent words in String[]-format
 * Test using FrequenceCounter yielded results:
 * N = 100, time taken by an average of 10 tests: 0.029ms, word "of"
 * N = 200, time taken by an average of 10 tests: 0.031ms, word "Chapter"
 * N = 400, time taken by an average of 10 tests: 0.033ms, word "Chapter"
 * N = 800, time taken by an average of 10 tests: 0.036ms, word "the"
 * N = 2000, time taken by an average of 10 tests: 0.041ms, word "the"
 * N = 10000, time taken by an average of 10 tests: 0.076ms, word "the"
 */



public class BinarySearchST<Key extends Comparable<Key>, Value>
{
	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST(10);
		st.put("abc", 1);
		st.put("ab", 1);
		st.put("a", 1);
		StdOut.print(st.keys());
		StdOut.print(st.keys("a", "abc"));
	}
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	//function to return all keys, works by first calling keys(int) to retrieve high and low keys
	//and then calling the recursive function key(key lo, key hi) which will return an ordered array of all keys
	public Key[] keys() {
		Key lo = keys[0];
		Key hi = keys[N-1];
		Key[] ret = keys(lo, hi);
		return ret;
	}
	
	public Key keys(int pos) {
		if (keys[pos] != null) 
		{
			return keys[pos];	
		}
		else return null;
	}
	
	public Key[] keys(Key lo, Key hi) {
		int f = rank(hi) - rank(lo);
		Key[] ret = (Key[]) new Comparable[f];
		for (int i = rank(lo); i < rank(hi); i ++) {
			ret[i] = lo;
		}
		return ret;
	}
	
	//constructor for BinarySearchST
	public BinarySearchST(int capacity)
	{ 
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	// determines rank of key, aka how many keys can be found "under/smaller" than said key.
	public int rank(Key key)
	{
		int lo = 0, hi = N-1; // iterates through all possible combinations
		while (lo <= hi) // uses binary search (halving each iteration) to search for rank
		{
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public int size()
	{ return N; }
	
	// returns value of Key
	public Value get(Key key)
	{
		if (size() == 0) return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return vals[i]; // checks whether it's the correct key
		else return null;
	}
	
	// function to add new key-value pairs
	public void put(Key key, Value val)
	{ 
		int i = rank(key); // rank is later used if key doesn't already exist in array
		if (i < N && keys[i].compareTo(key) == 0) // if key already exists in array, update Value
		{ vals[i] = val; return; }
		for (int j = N; j > i; j--) // move all elements after Key one position "up"
		{ keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
		keys[i] = key; vals[i] = val;
		N++; // increase size
	}
	// simple function to determine whether array contains Key
	public boolean contains(Key key) {
		if(get(key) != null) {
			return true;
		}
		else return false;
	}
	
	//returns n to nxth most frequent words of symbol tree st
	public String[] nMaxKeys(int n, int nxth, BinarySearchST<String, Integer> st) 
	{
		String max = "";
		st.put(max, 0); // add a new key-value pair max-0 which will be placeholder for max keys
		String[] ret = new String[nxth-n]; // String array to be returned with max keys in string form
		int count = 0; // counter to keep track of n and nxth
		int countret = 0; 
		if((nxth - n) > 0) {
			for (int i = 0; i < st.size(); i++) // for loop that is repeated n-nxth times
			{
				if (st.get(st.keys(i)) > st.get(max)) // finds max key
				{	
					String newmax = st.keys(i);
					//StdOut.print(newmax + st.get(st.keys(i)));
					max = newmax;
				}
				if(count < n  && i == st.size() - 1)  // if n is larger than 1 (i.e dont want first-n words)
				{  // then simply set their Val to 0
					//StdOut.print("123"); count++; i = 0;
					st.put(max, 0);
				}
				else if(count >= n && count < nxth && i == st.size() - 1) { // once all unwanted words are removed
					ret[countret] = max; // add max word to String[] to be returned, increase counters and reset forloop
					countret++;
					st.put(max, 0);
					count++;
					i = 0;
				}
			}
			return ret;
		}
		else throw new ArrayIndexOutOfBoundsException();	
	}
	
	/*public String nMaxKeys(int n, int nxth, BinarySearchST<String, Integer> st) {
		
		String max = "";
		st.put(max, 0);
		int count = 0;
		if((nxth - n) > 0) {
			for (int i = 0; i < st.size(); i++) 
			{
				if (st.get(st.keys(i)) > st.get(max)) 
				{	
					String newmax = st.keys(i);
					StdOut.print(newmax + st.get(st.keys(i)));
					max = newmax;
				}
				if(count < n  && i == st.size() - 1) { StdOut.print("123"); count++; i = 0;
				st.put(max, 0);
				}
			}
			return max;
		}
		else throw new ArrayIndexOutOfBoundsException();	
	}
	
	public String nMaxKeys(int n, int nxth, BinarySearchST<String, Integer> st) {
		String max = "";
		st.put(max, 0);
		
		if((nxth - n) > 0) {
			for (int i = 0; i < st.size(); i++) 
			{
				if (st.get(st.keys(i)) > st.get(max)) 
				{
					String newmax = st.keys(i);
					max = newmax;
				}
			}
			return max;
		}
		else throw new ArrayIndexOutOfBoundsException();*/
		
	}
	

	

