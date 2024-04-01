package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17931 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] mat = new int[n][m];
		int[][] dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				dp[i][j] = 100000000;
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				int tmp = mat[i][j];
				for(int k = 1 ; k <= tmp; k ++) {
					if(i + k < n) {
						dp[i + k][j] = Math.min(dp[i + k][j], dp[i][j] + 1);
					}
					if(j + k < m)
						dp[i][j + k] = Math.min(dp[i][j + k], dp[i][j] + 1);
				}
			}
		}
		System.out.println(dp[n - 1][m - 1] - 1);
	}
}
