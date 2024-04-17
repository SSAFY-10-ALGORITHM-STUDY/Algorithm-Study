import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj21924 {

	static class Edge{
		int from;
		int to;
		int dist;

		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	static int find(int x){
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y){
		if(parent[x]==parent[y]) return;
		x = parent[x];
		y = parent[y];
		if(x>y) parent[x] = y;
		else parent[y] = x;
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i]=i;
		}
		List<Edge> edges = new ArrayList<>();
		long total = 0L;
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());
			total+=dist;
			edges.add(new Edge(from, to, dist));
		}
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.dist-o2.dist;
			}
		});
		long answer = 0L;
		for(Edge edge: edges){
			int from = edge.from;
			int to = edge.to;
			int dist = edge.dist;
			if(find(from)!=find(to)){
				union(from, to);
				answer+=dist;
			}
		}
		answer = total-answer;
		int first = find(1);
		for (int i = 2; i <=n ; i++) {
			if(first!=find(i)){
				answer=-1;
				break;
			}
		}
		sb.append(answer);
		System.out.println(answer);
	}
}