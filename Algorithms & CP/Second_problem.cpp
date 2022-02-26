#include <bits/stdc++.h>
using namespace std;


int main(){
					
	// dealing with inputs
	int n; cin>>n;
	int matrix[n][n];
	
	for (int i=0; i<n; i++){
		for (int j=0; j<n; j++){
			cin >> matrix[j][i];
    	}
	}

	// reverse every row
	for (int i = 0; i < n; i++){
		reverse(matrix[i], matrix[i] + n);
	}
		
	// transpose
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++)
			swap(matrix[i][j], matrix[j][i]);
	}
	
	// printing results
	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout<<matrix[j][i]<<" ";
        printf("\n");
    }

	return 0;
}

