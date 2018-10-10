public class DirectedDFS
{
	private boolean[] marked;
	
	public DirectedDFS(Digraph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources)
	{
		marked = new boolean[G.V()];
		for (int s : sources)
			if (!marked[s]) dfs(G, s);
	}
	
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w]) dfs(G, w);
	}
	
	public boolean marked(int v)
	{ return marked[v]; }
	
	public static void main(String[] args)
	{
		String[] States = {"a", "b", "c", "d", "e", "f", "g"};
		Digraph G = new Digraph(States.length, States, new In(args[0]));
		String Y = args[2];
		Bag<Integer> sources = new Bag<Integer>();
		sources.add(G.StateIndex(args[1]));
		DirectedDFS reachable = new DirectedDFS(G, sources);
		if (reachable.marked(G.StateIndex(Y))) StdOut.print("A path exists");
		else StdOut.print(("No path exists"));
		StdOut.println();
		
			
			
			
	}
}
