
public class Digraph
{
	public static void main(String[] args) {
		String[] States = {"a", "b", "c", "d"};
		In in = new In(args[0]);
		In in2 = new In(args[1]);
		/*int tempsize = 0;
		while(in.hasNextLine())
		{ // Add an edge.
			if(tempsize >= States.length /2) {
				String[] ret = new String[States.length * 2];
				for(int i = 0; i < States.length; i++) {
					ret[i] = States[i];
				}
				States = ret;
			}
			String V = in.readString();
			States[tempsize] = V;
			tempsize++;
			String w = in.readString(); // read another vertex
			States[tempsize] = w;
			tempsize++;
			//addEdge(v, w); // and add edge connecting them.
		}*/
		
		Digraph G = new Digraph(States.length, States, in2);
		
		/*addstate("abc");
		addstate("abcd");
		StdOut.print(StateIndex("abc"));
		StdOut.print(StateContains("abc"));
		StdOut.print(StateIndex("abcd"));
		StdOut.print(StateContains("abcd"));
		addEdge(0, "abcd");*/
		for(int i = 0; i < G.States.length; i++) {
			StdOut.println(G.States[i]);
		}
		int[][] print = G.edgestoString();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(print[i][j] != -1) {
				StdOut.print(print[i][j]);
				}
			}
		}
	}
	private static int V = 0;
	private static int size = 0;
	private static int E;
	private static Bag<Integer>[] adj;
	private static String[] States = new String[1];
	
	public static void addstate (String state) {
		if(!StateContains(state)) {
			States[size] = state;
			size++;
		}
	}
	
	public static String getstate(int v) {
		return States[v];
	}
	
	public Digraph(int V, String[] states, In in)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
		States = states;
		
		while(in.hasNextLine()) {
		String x = in.readString();
		String y = in.readString();
		//StdOut.print("Adding " + x + " " + y);
		addEdge(StateIndex(x), StateIndex(y));
		}
	}
	
	public int[][] edgestoString() {
		int[][] ret = {
				{-1,-1,-1},
				{-1,-1,-1},
				{-1,-1,-1},
				{-1,-1,-1}
		};
		//test should be at index 3
		for(int i = 0; i < 3; i++) {
			int j = 0;
			for(int w : adj[i]) {
				ret[i][j] = w;
				j++;			
			}
		}
		return ret;
	}
	
	public int V() { return V; }
	
	public int E() { return E; }
	
	public static int StateIndex(String State) {
		for(int i = 0; i < States.length; i++) {
			if(State.equals(States[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean StateContains(String State) {
		for(int i = 0; i < States.length; i++) {
			if(State.equals(States[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v)
	{ return adj[v]; }

	
	/*public Digraph(In in)
	{
		//this(in.readInt()); // Read V and construct this graph.
		//int E = in.readInt(); // Read E.
		/*while(in.hasNextLine())
		{ // Add an edge.
			if(size >= States.length /2) {
				arrayResize();
			}
			String V = in.readString();
			addstate(V);
			String w = in.readString(); // read another vertex
			addstate(w);
			int v = StateIndex(V); 
			//addEdge(v, w); // and add edge connecting them.
		}
	 }*/
	
	/*public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++)
			for (int w : adj(v))
				R.addEdge(w, v);
		return R;
	}*/
	
	public static void arrayResize() {
		String[] ret = new String[States.length * 2];
		for(int i = 0; i < States.length; i++) {
			ret[i] = States[i];
		}
		States = ret;
	}
}
