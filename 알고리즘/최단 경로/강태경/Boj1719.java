import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1719 {

    static final int MAX_DIST = 200000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[][] dist = new int[n+1][n+1];
		int[][] next = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], MAX_DIST);
			dist[i][i]=0;
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			dist[a][b] = cost;
			dist[b][a] = cost;
			next[a][b] = b;
			next[b][a] = a;
		}

		for(int k=1; k<=n;k++){
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					int cost = dist[i][k]+dist[k][j];
					if(dist[i][j]>cost){
						dist[i][j] = cost;
						if(next[i][k]!=0)next[i][j] = next[i][k];
						else next[i][j] =next[k][j];
					}
				}
			}
		}

		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <= n; j++) {
				if(next[i][j]==0) sb.append("- ");
				else sb.append(next[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}