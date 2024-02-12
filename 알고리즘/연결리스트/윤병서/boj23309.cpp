#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
	cin.tie(0);
	int n, m; cin >> n >> m;
	int arr[n + 1];
	for(int i = 0 ; i < n ; i ++){
		cin >> arr[i];
	}
	vector<pair<int,int>> v(1000001);
	
	for(int i = 0 ; i < n ; i ++){
		if(i == 0){
			v[arr[0]] = {arr[n - 1], arr[1]};
		}
		else if(i == n - 1){
			v[arr[n - 1]] = {arr[n - 2], arr[0]};
		}
		else{
			v[arr[i]] = {arr[i - 1], arr[i + 1]};
		}
	}
	
	
	for(int i = 0 ; i < m ; i ++){
		string a; cin >> a;
		if(a == "BN"){
			int cur, nxt;
			cin >> cur >> nxt;
			cout << v[cur].second << '\n';
			v[v[cur].second] = {nxt, v[v[cur].second].second};
			v[nxt] = {cur, v[cur].second};
			v[cur] = {v[cur].first, nxt};
		}
		else if(a == "BP"){
			int cur, prev;
			cin >> cur >> prev;
			cout << v[cur].first << '\n';
			v[v[cur].first] = {v[v[cur].first].first, prev};
			v[prev] = {v[cur].first, cur};
			v[cur] = {prev, v[cur].second};
		}
		else if(a == "CN"){
			int cur;
			cin >> cur;
			cout << v[cur].second << '\n';
			int nxt_node = v[cur].second;
			v[v[nxt_node].second] = {cur, v[v[nxt_node].second].second};
			v[cur] = {v[cur].first, v[nxt_node].second};
			v[nxt_node] = {0, 0};
		}
		else{
			int cur;
			cin >> cur;
			cout << v[cur].first << '\n';
			int prev_node = v[cur].first;
			v[v[prev_node].first] = {v[v[prev_node].first].first, cur};
			v[cur] = {v[prev_node].first, v[cur].second};
			v[prev_node] = {0, 0};
		}
	}
}
