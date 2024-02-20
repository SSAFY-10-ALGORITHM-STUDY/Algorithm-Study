import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[][] dist = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i!=j) dist[i][j] = 10_000_000;
			}
		}
		for(int i=0; i<n-1; i++) {
			stk = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(stk.nextToken());
			int second = Integer.parseInt(stk.nextToken());
			int distance = Integer.parseInt(stk.nextToken());
			dist[first][second] = distance;
			dist[second][first] = distance;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		
		while(m-->0) {
			stk = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(stk.nextToken());
			int second = Integer.parseInt(stk.nextToken());
			sb.append(dist[first][second]).append("\n");
		}

		System.out.println(sb);
	}
}
