/*Task Two
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * Exactly the same as task One except BFS is used and shortest path is found
 */

public class BreadthFirstPaths
{
	public static void main(String[] args)
	{
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]); // Path from s to Y
		int Y = Integer.parseInt(args[2]);
		BreadthFirstPaths search = new BreadthFirstPaths(G, s);
		StdOut.print(s + " to " + Y + ": ");
		if (search.hasPathTo(Y)) // check whether any path exists
			for (int x : search.pathTo(Y)) // iterate over pathTo and get a path from s to Y
				if (x == s) StdOut.print(x);
				else StdOut.print("-" + x);
			StdOut.println();
	}
	
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public BreadthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	private void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true; // Mark the source
		queue.enqueue(s); // and put it on the queue.
		while (!queue.isEmpty())
		{
			int v = queue.dequeue(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
 			if (!marked[w]) // For every unmarked adjacent vertex,
 			{
 				edgeTo[w] = v; // save last edge on a shortest path,
 				marked[w] = true; // mark it because path is known,
 				queue.enqueue(w); // and add it to the queue.
 			}
		}
	}
	
	public boolean hasPathTo(int v)
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
