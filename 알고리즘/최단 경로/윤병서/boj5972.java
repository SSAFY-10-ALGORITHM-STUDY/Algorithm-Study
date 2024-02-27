package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj5972 {

	static class Node implements Comparable<Node> {
		int idx, cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static List<List<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Node(v, w));
			list.get(v).add(new Node(u, w));
		}

		int dist[] = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		dist[1] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.idx] < cur.cost)
				continue;

			for (int i = 0; i < list.get(cur.idx).size(); i++) {
				Node nxt = list.get(cur.idx).get(i);

				if (dist[nxt.idx] > cur.cost + nxt.cost) {
					dist[nxt.idx] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.idx, cur.cost + nxt.cost));
				}
			}
		}
		System.out.println(dist[V]);
	}
}
