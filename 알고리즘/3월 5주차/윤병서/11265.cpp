#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int n, m; cin >> n >> m;

	long long mat[n + 1][n + 1];
	for(int i = 0 ; i < n ; i ++){
		for(int j = 0 ; j < n ; j ++){
			cin >> mat[i][j];
		}
	}
	
	for(int i = 0 ; i < n ; i ++){
		for(int j = 0 ; j < n ; j ++){
			for(int k = 0 ; k < n ; k ++){
				mat[j][k] = min(mat[j][k], mat[j][i] + mat[i][k]);
			}
		}
	}
	
	for(int i = 0 ; i < m ; i ++){
		int a, b, c; cin >> a >> b >> c;
		if(mat[a - 1][b - 1] <= c) cout << "Enjoy other party\n";
		else cout << "Stay here\n";
	}
}
