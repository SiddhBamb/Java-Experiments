import java.util.*;
import java.io.*;

public class Summing
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		int numLines = scan.nextInt();
		
		for(int i = 0; i < numLines; i++)
		{
			int a = scan.nextInt();
			int b = scan.nextInt();
			results.add((a+b));
		}
		for(int i : results)
			System.out.println(i);
		
	}
}