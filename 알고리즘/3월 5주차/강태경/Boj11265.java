package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11265 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[][] dist = new int[n][n];
		for(int i=0; i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n;j++) {
				dist[i][j] = Integer.parseInt(stk.nextToken()); 
			}
		}
		
		for(int k=0; k<n;k++) {
			for(int i=0; i<n;i++) {
				for(int j=0; j<n;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		while(m-->0) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken())-1;
			int to = Integer.parseInt(stk.nextToken())-1;
			int time = Integer.parseInt(stk.nextToken());
			if(dist[from][to]<=time) sb.append("Enjoy other party\n");
			else sb.append("Stay here\n");
		}
		System.out.println(sb);
	}
}