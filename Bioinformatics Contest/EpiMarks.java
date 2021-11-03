import java.util.*;
import java.io.*;

public class EpiMarks
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		ArrayList<String> arr;
		ArrayList<String> arr2;
		LinkedHashMap<String, Integer> lhm;
		for(int x = 0; x < t; x++)
		{
			int m = 1;
			arr = new ArrayList<String>();
			arr2 = new ArrayList<String>();
			lhm = new LinkedHashMap<String, Integer>();
			int n = scan.nextInt();
			int l = scan.nextInt();
			for(int i = 0; i < n; i++)
			{
				arr.add(scan.next());
			}
			String current = "";
			for(int i = 0; i < l; i++)
			{
				current = "";
				for(int j = 0; j < n; j++)
				{
					current += "" + arr.get(j).charAt(i);
				}
				arr2.add(current);
				//System.out.println(current);
				if(!lhm.containsKey(current))
				{
					lhm.put(current, m);
					m++;
				}
			}
			System.out.println(lhm.size());
			for(String s : arr2)
			{
				System.out.print(lhm.get(s) + " ");
			}
			System.out.println();
		}	
	}
}