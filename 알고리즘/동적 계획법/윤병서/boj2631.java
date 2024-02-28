package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2631 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int kids[] = new int[n + 1];
		for(int i = 0 ; i < n ; i ++) {
			kids[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[n];
		dp[0] = 1;
		
		for(int i = 1; i < n ; i ++) {
			dp[i] = 1;
			for(int j = 0; j < i ; j ++) {
				if(kids[j] < kids[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int ma = 0;
		for(int i = 0 ; i < n ; i ++) {
			ma = Math.max(ma, dp[i]);
		}
		System.out.println(n - ma);
	}
}
