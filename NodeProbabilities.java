import java.util.*;

public class NodeProbabilities
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Number of rounds for simulation?");
		int n = scan.nextInt();
		
		//adjacency list for the graph, probabilities of going to each node
		double[][] graph = {{2.0/3.0, 1.0/3.0, 0.0}, {0.5, 0.0, 0.5}, {1.0/3.0, 1.0/3.0, 1.0/3.0}};
			
		getProbabilities(graph, n);
	}
	
	public static void getProbabilities(double[][] arr, int n)
	{
		//array which has space for arr.length simulations (each starting at a different node), and spaces for the number of times each node is visited
		double[][] probs = new double[arr.length+1][arr.length];
		
		//makes probabilities into ranges
		//example: {1/4, 1/2, 1/4} becomes {1/4, 3/4, 1.0}
		//allows for rng to determine which node to go to next
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 1; j < arr[i].length; j++)
			{
				arr[i][j] = arr[i][j]+arr[i][j-1];
			}
		}
		
		//initializes values for the next loops
		int current = 0;
		double prob = 0;
		
		//conducts x simulations
		for(int x = 0; x < arr.length; x++)
		{
			//for the xth simulation, start off at the xth node
			current = x;
			//increase number of times this node has been visited by 1 for the xth simulation
			probs[x][current] = probs[x][current] + 1;
			
			//go through n steps
			for(int i = 0; i < n; i++)
			{
				//generate random number
				prob = Math.random();
				
				int a = 0;
				//use random number to figure out which node to go to next (if it is between the values of the previous prob value inclusive and the prob value itself exclusive, then go to the node corresponding to the prob value)
				for(int j = arr[current].length-1; j >= 0; j--)
				{
					if(prob < arr[current][j] && (j>0 ? prob >= arr[current][j-1] : prob >= 0.0)){
						
						
						a = j;
						break;
					}
				}
				//go to the next node, based on the rng
				current = a;
				//increase number of times this node has been visited by 1 for the xth simulation
				probs[x][current] = probs[x][current] + 1;
			}
		}
		
		//use the final row of the probs array to store, for each node, the total number of times it was visited for all simulations combined
		for(int col = 0; col < arr[0].length; col++)
		{
			for(int row = 0; row < arr.length; row++)
			{
				probs[arr.length][col] = probs[arr.length][col] + probs[row][col];
			}
		}
		
		//normalize the values of the last row of probs so they are out of 1, making them probabilities
		for(int i = 0; i < probs[arr.length].length; i++)
		{
			probs[arr.length][i] = (probs[arr.length][i]*1.0) / (arr.length * n * 1.0);
		}
		
		//print out the last row of probs
		for(double d : probs[arr.length])
		{
			System.out.println(d);
		}
	}
}