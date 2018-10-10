
public class SequentialSearchST<Key, Value>
{
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("abc", 1);
		st.put("ab123c", 1);
		st.put("ab12asd3c", 1);
		st.put("ab322c", 1);
		String[] abc = st.keys();
		StdOut.print(st.get(abc[0]));
		StdOut.print(abc[0]);
		StdOut.print(abc[1]);
		StdOut.print(abc[2]);
		StdOut.print(abc[3]);
	}
	
	private Node first; // first node in the linked list
	private int size = 0;
	private class Node
	{ // linked-list node
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key)
	{ // Search for key, return associated value.
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				//StdOut.print(x.key);
				return x.val; // search hit
			}
		return null; // search miss
	}
	
	public void put(Key key, Value val)
	{ // Search for key. Update value if found; grow table if new.
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
			{ x.val = val; return; } // Search hit: update val.
		first = new Node(key, val, first); // Search miss: add new node.
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public String[] keys() {
		String[] ret = new String[size];
		ret[0] = (String) first.key;
		first = first.next;
		for(int i = 1; i < size; i++) {
			ret[i] = (String) first.key;
			first = first.next;
		}
		return ret;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
}
