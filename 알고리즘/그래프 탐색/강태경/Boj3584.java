package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj3584 {
	
	static void dfs(int num, int depth) {
		depth++;
		for(int next: childs.get(num)) {
			d[next] = depth;
			dfs(next, depth);
		}
	}
	
	static int lca(int first, int second) {
		while(d[first]!=d[second]) {
			if(d[first]>d[second]) {
				first = parent[first];
			} else second = parent[second];
		}
		while(first!=second) {
			first = parent[first];
			second = parent[second];
		}
		return first;
	}
	
	static int[] parent, d;
	static List<ArrayList<Integer>> childs;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			d = new int[n+1];
			childs = new ArrayList<>();
			for(int i=0; i<=n;i++) {
				childs.add(new ArrayList<>());
			}
			for(int i=1; i<n;i++) {
				stk = new StringTokenizer(br.readLine());
				int nparent = Integer.parseInt(stk.nextToken());
				int child = Integer.parseInt(stk.nextToken());
				parent[child] = nparent;
				childs.get(nparent).add(child);
			}
			int root = 1;
			while(parent[root]!=0) {
				root = parent[root];
			}
			dfs(root, 0);
			stk = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(stk.nextToken());
			int second = Integer.parseInt(stk.nextToken());
			int answer = lca(first, second);
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
}