/* Task Six
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * Implemented using code from book with only slight changes
*/
public class DirectedCycle
{
	public static void main(String[] args) {
		String[] States = readGraph.readGraph(new In(args[0]));
		Digraph G = new Digraph(States.length, States, new In(args[0]));
		DirectedCycle Dir = new DirectedCycle(G);
		if(Dir.hasCycle()) {StdOut.print("A cycle exists");}
		else {StdOut.print("No cycle exists");}
	}
	
	private boolean[] marked;
	private int[] edgeTo;
	private ResizingArrayStack<Integer> cycle; // vertices on a cycle (if one exists)
	private boolean[] onStack; // vertices on recursive call stack
	
	public DirectedCycle(Digraph G)
	{
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v]) dfs(G, v);
	}
	
	private void dfs(Digraph G, int v)
	{
		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v))
			if (this.hasCycle()) return;
			else if (!marked[w])
			{ edgeTo[w] = v; dfs(G, w); }
			else if (onStack[w]) // means that a cycle exists
			{
				cycle = new ResizingArrayStack<Integer>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
	}
	
	public boolean hasCycle()
	{ return cycle != null; }
	
	public Iterable<Integer> cycle()
	{ return cycle; }
}