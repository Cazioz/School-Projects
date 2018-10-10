public class DepthFirstPaths
{
	public static void main(String[] args)
	{
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]); // Path from s to Y
		int Y = Integer.parseInt(args[2]);
		DepthFirstPaths search = new DepthFirstPaths(G, s);
		StdOut.print(s + " to " + Y + ": ");
		if (search.hasPathTo(Y)) // check whether any path exists
			for (int x : search.pathTo(Y)) // 
				if (x == s) StdOut.print(x);
				else StdOut.print("-" + x);
			StdOut.println();
	}
	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public DepthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
	}
	
	public boolean hasPathTo(int v)
	{ return marked[v]; }
	
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v)) return null;
		ResizingArrayStack<Integer> path = new ResizingArrayStack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}