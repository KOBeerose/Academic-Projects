#include <bits/stdc++.h>
using namespace std;


int gcd(int a,int b) {
  int R;
  while ((a % b) > 0)  {
    R = a % b;
    a = b;
    b = R;
    cout<<a<<endl<<b<<endl<<R<<endl;
  }
  
  return b;
}

int main()
{
					
	// dealing with inputs
	int a; cin>>a;
	int b; cin>>b;
	
	cout<<gcd(a,b)<<endl;

	return 0;
}
