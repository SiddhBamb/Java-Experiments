import java.util.*;
import java.io.*;

public class MetAnnotation
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		double[] m;
		double[] a;
		double[] s;
		for(int l = 0; l < t; l++)
		{
			
			
			int numM = scan.nextInt();
			int numK = scan.nextInt();
			int numN = scan.nextInt();
			
			m = new double[numM]; //new ArrayList<Double>();
			a = new double[numK]; //ArrayList<Double>();
			s = new double[numN]; //ArrayList<Double>();
			
			for(int i = 0; i < numM; i++)
				m[i]=scan.nextDouble();
			for(int i = 0; i < numK; i++)
				a[i]=scan.nextDouble();
			for(int i = 0; i < numN; i++)
				s[i]=scan.nextDouble();
			
			double minValue = Double.MAX_VALUE;
			String maxjk = "";
			
			for(int i = 0; i < s.length; i++)
			{
				minValue = Double.MAX_VALUE;
				maxjk = "";
				
				for(int j = 0; j < m.length; j++)
				{
					for(int k = 0; k < a.length; k++)
					{
						if(m[j] + a[k] > 0 && Math.abs(s[i] - m[j] - a[k]) < minValue)
						{
							minValue = Math.abs(s[i] - m[j] - a[k]);
							maxjk = "" + (j+1) + " " + (k+1);
						}
					}
				}
				//print the minimized j and k values
				System.out.println(maxjk);
			}
		}
	}
}