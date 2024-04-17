import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5972 {
	
	static class Pair{
		int node;
		int dist;

		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	static int[] distance;
	static List<ArrayList<Pair>> graph;

	static void dijkstra(int start){
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.dist-o2.dist;
			}
		});
		pq.add(new Pair(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()){
			Pair p = pq.remove();
			int now = p.node;
			int dist = p.dist;
			if(distance[now]<dist) continue;

			for(int i =0; i<graph.get(now).size();i++){
				int next = graph.get(now).get(i).node;
				int cost = distance[now]+graph.get(now).get(i).dist;
				if(distance[next]>cost){
					distance[next] = cost;
					pq.add(new Pair(next, cost));
				}
			}
		}


	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());


		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());
			graph.get(from).add(new Pair(to, dist));
			graph.get(to).add(new Pair(from, dist));
		}

		distance = new int[n+1];
		Arrays.fill(distance, 50000000);

		dijkstra(1);
		sb.append(distance[n]);
		System.out.println(sb);
	}
}