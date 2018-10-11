/*Task One
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * DepthFirstPaths(Graph G, int s) runs entire DFS algorithm
 * hasPathTo(int v) returns true if a path from int s to int v exists
 * pathTo(int v) returns an iterable stack with path to v from s
 */

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
			for (int x : search.pathTo(Y)) // iterate over pathTo and get a path from s to Y
				if (x == s) StdOut.print(x);
				else StdOut.print("-" + x);
			StdOut.println();
	}
	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public DepthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()]; // has this node been visited
		edgeTo = new int[G.V()]; 
		this.s = s;  // this is the source 
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) // the actual algorithm
	{
		marked[v] = true;
		for (int w : G.adj(v)) 
			if (!marked[w])
			{
				edgeTo[w] = v; //remembers path
				dfs(G, w); // recursive call 
			}
	}
	
	public boolean hasPathTo(int v) // if vertex has been marked then a path surely exists
	{ return marked[v]; }
	
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v)) return null; // if no path exists
		ResizingArrayStack<Integer> path = new ResizingArrayStack<Integer>(); // used to save the path
		for (int x = v; x != s; x = edgeTo[x]) // pushes the last vertex to stack effectively creating a path
			path.push(x);
		path.push(s);
		return path;
	}
}