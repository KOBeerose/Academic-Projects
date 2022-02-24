#include <bits/stdc++.h>
 
using namespace std;

// calculating the distance between each 
int NearestBox( vector<string> Children;, vector<string> Boxes){
	vector<int> distances = [];
	for(auto box: Boxes){
	    cout << box << endl;
        distance = math.sqrt((boxX-childX)**2+(boxY-childY)**2)
        distances.append((boxId, distance))
        	    vector<float> distances = calcDist(child, Boxes);
	    int boxNear= min(distances);
        return distances
	}
}
int main() {

	vector<int> Children;
	vector<int> Boxes;
	
	// dealing with inputs
	int n; cin>>n;
    for (int i=0; i<n; i++){
    	string boxId;
		int boxX, boxY;
    	cin>>boxId>>boxX>>boxY;
    	Boxes.insert(Boxes.end(), { boxX, boxY });
	}
	
	int k; cin>>k;
	for (int i=0; i<k; i++){
		string childId;
		int childX, childY;
    	cin>>childId>>childX>>childY;
    	Children.insert(Children.end(), { childX, childY });
	}
	
	// choosing the smallest distance for each child
	for(auto child: Children){
	    cout << child << endl;
	    int boxNear= NearestBox(child, Boxes);
	    cout<<child[0]<<boxNear<<endl;
	}
	
	
	
    return 0;

}


