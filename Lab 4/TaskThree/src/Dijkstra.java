/* Task Three
 * Written by Oscar Eklund
 * Last Edited: 2018-10-11
 * In hindsight this implementation could've been done much better..
 */
public class Dijkstra {
	
	public static void main(String[] args){
		int X = Integer.parseInt(args[0]);
		int Y = Integer.parseInt(args[1]);
		int[] preD = new int[5];
		int min = 100000000, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node. 
		int[] distance = new int[5]; // the distance matrix holds the length of shortest path X to Y
		//int[][] matrix = new int[5][5]; // the actual matrix representing vertices
		boolean[] visited = new boolean[5]; // the visited array, marks a vertex as visited when visited
		
		//System.out.println("Enter the matrix represented by edge weights"); 
		int matrix[][] = {
				{0,5,10,0,0},
				{5,0,0,10,5},
				{10,0,0,10,20},
				{0,10,10,0,0},
				{0,5,20,0,0}
		};
		
		for(int i = 0; i < distance.length; i++){
			
			visited[i] = false; //initialize visited array to zeros
			preD[i] = X;

			for(int j = 0; j < distance.length; j++){
				//matrix[i][j] = StdIn.readInt(); //fill the matrix
				if(matrix[i][j]==0){				
					matrix[i][j] = 100000000; // make the zeros big values (note max value does not work)	
				}				
			}			
		}
		
		distance = matrix[X]; //initialize the distance array
		visited[X] = true; //set the source node as visited
		distance[X] = 0; //set the distance from source to source to zero which is the starting point
		
		for(int counter = 0; counter < 5; counter++){
			
			min =  100000000;
			
			for(int i = 0; i < 5; i++){ // finds next node with smallest distance that has not been visited
				if(min > distance[i] && visited[i] != true){			
					min = distance[i];
					nextNode = i;					
				}			
			}
			
			visited[nextNode] = true;
			
			for(int i = 0; i < 5; i++){	
				if(visited[i] != true){	
					if(min+matrix[nextNode][i] < distance[i]){ //if total distance is less than previous smallest distance
						distance[i] = min+matrix[nextNode][i]; //we found a better way and update preD
						preD[i] = nextNode;
						
					}	
				}				
			}			
		}
		
		int j = Y;
		/*for(int i = 0; i < 5; i++){		
			System.out.print("|" + distance[i]);		
		}
		System.out.println("|");*/
		
		/*for(int i = 0; i < 5; i++){		
			if(i!=S){				
				System.out.print("Path = " + i);
				j = i;
				do{					
					j=preD[j];
					System.out.print(" <- " + j);				
				}while(j!=S);	
				System.out.println();	
			}		
					
		}*/
		System.out.print("Path = " + Y);
		do {
			j=preD[j];
			System.out.print(" <- " + j);
		}while(j!=X);
	}		
}