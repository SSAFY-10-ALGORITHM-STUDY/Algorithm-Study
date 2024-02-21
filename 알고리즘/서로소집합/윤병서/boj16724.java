package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16724 {
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n * m + 1];
		for (int i = 1; i <= n * m; i++) {
			parents[i] = i;
		}

		char mat[][] = new char[n][m];
		boolean visited[][] = new boolean[n][m];
		int ans[] = new int[n * m + 1];

		for (int i = 0; i < n; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < m; j++) {
				mat[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false) {
					visited[i][j] = true;
					if (mat[i][j] == 'D') {
						union(i * m + j + 1, (i + 1) * m + j + 1);
					}
					if (mat[i][j] == 'U') {
						union(i * m + j + 1, (i - 1) * m + j + 1);
					}
					if (mat[i][j] == 'L') {
						union(i * m + j + 1, i * m + j);
					}
					if (mat[i][j] == 'R') {
						union(i * m + j + 1, i * m + j + 2);
					}
				}
			}
		}
		
		for(int i = 1; i <= n * m ; i ++) {
			int k = find(i);
			ans[k] = 1;
		}
		
		int res = 0;
		for(int i = 1; i <= n * m ; i ++) {
			if(ans[i] == 1) res ++;
		}
		System.out.println(res);
	}

	private static int find(int cur) {
		if (parents[cur] == cur)
			return cur;
		return parents[cur] = find(parents[cur]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			return;
		}
		parents[rootB] = rootA;
	}
}
