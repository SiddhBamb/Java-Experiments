#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(int l = 0; l < t; l++)
	{
		int numM;
		cin >> numM;
		int numK;
		cin >> numK;
		int numN;
		cin >> numN;
		
		double m[numM];
		double a[numK];
		double s[numN];
		
		for(int i = 0; i < numM; i++)
		{
			cin >> m[i];
		}
		for(int i = 0; i < numK; i++)
		{
			cin >> a[i];
		}
		for(int i = 0; i < numN; i++)
		{
			cin >> s[i];
		}
		
		double minValue = std::numeric_limits<double>::max();
		string maxjk = "";
		
		for(int i = 0; i < numN; i++)
		{
			minValue = std::numeric_limits<double>::max();
			maxjk = "";
			
			for(int j = 0; j < numM; j++)
			{
				for(int k = 0; k < numK; k++)
				{
					if(m[j] + a[k] > 0 && fabs(s[i] - m[j] - a[k]) < minValue)
					{
						minValue = fabs(s[i] - m[j] - a[k]);
						maxjk = "" + std::to_string(j+1) + " " + std::to_string(k+1);
					}
				}
			}
			//print the minimized j and k values
			cout<<maxjk<<endl;
		}
	}
}