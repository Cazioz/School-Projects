/* Task Five & Six
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * Creates String[] States from a file input using books library In.java
 * Most code is copied from my implementation of Digraph, see Readme of Digraph for more info
*/
public class readGraph {

	private static String[] States = new String[2];
	private static int size = 0;
	
	public static String[] readGraph(In in) {
		
		while(in.hasNextLine())
		{ // Add an edge.
			if(size >= States.length /2) {
				States = resize(States);
			}
			String V = in.readString();
			addstate(V);
			//States[tempsize] = V;
			//tempsize++;
			String w = in.readString(); // read another vertex
			//States[tempsize] = w;
			//tempsize++;
			addstate(w);
		}
		return States;
	}
	
	public static String[] resize(String[] res) {
		String[] ret = new String[res.length * 2];
		for(int i = 0; i < res.length; i++) {
			ret[i] = res[i];
		}
		return ret;
	}
	
	public static boolean StateContains(String State) {
		for(int i = 0; i < States.length; i++) {
			if(State.equals(States[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void addstate (String state) {
		if(!StateContains(state)) {
			States[size] = state;
			size++;
		}
	}
}
