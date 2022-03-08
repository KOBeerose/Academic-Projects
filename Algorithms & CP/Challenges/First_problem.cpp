#include <bits/stdc++.h>
 
using namespace std;


int main() {

	vector < vector<int> > Children;
	vector < vector<int> > Boxes;
	
	// dealing with inputs
	int n; cin>>n;
    for (int i=0; i<n; i++){
    	string boxId;
		int boxX, boxY;
    	cin>>boxId>>boxX>>boxY;
    	Boxes.insert(Boxes.end(), { {boxX, boxY} } );
	}
	int k; cin>>k;
	for (int i=0; i<k; i++){
		string childId;
		int childX, childY;
    	cin>>childId>>childX>>childY;
    	Children.insert(Children.end(), { {childX, childY} });
	}

	// choosing the smallest distance for each child
	for(int i=0; i<k; i++){
		int boxNear=0;
		float distance, min = 99999999999;
	    for(int j=0; j<n; j++){
	        distance = sqrt( pow( (Boxes[j][0]-Children[i][0]), 2) + pow( (Boxes[j][1]-Children[i][1]), 2) );
	        //cout<<j<<endl<<distance<<" < "<<min<<endl;
	        if (distance < min) {
	        	min = distance;
	        	boxNear = j+1;
			} 
			//cout<<distance<<endl<<min<<endl;
		}
		cout<<"p"<<(char)(i+65)<<" Box"<<boxNear<<endl;
	}
	
    return 0;

}


