



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
	
	public BinarySearchST(int capacity)
	{ 
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int rank(Key key)
	{
		int lo = 0, hi = N-1;
		while (lo <= hi)
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
	
	public Value get(Key key)
	{
		if (size() == 0) return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return vals[i];
		else return null;
	}
	
	public void put(Key key, Value val)
	{ // Search for key. Update value if found; grow table if new.
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
		{ vals[i] = val; return; }
		for (int j = N; j > i; j--)
		{ keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
		keys[i] = key; vals[i] = val;
		N++;
	}
	
	public boolean contains(Key key) {
		if(get(key) != null) {
			return true;
		}
		else return false;
	}
	
	
}
