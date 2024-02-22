package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj21924 {
	static int V;
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static Edge[] edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		long amount = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
			amount += weight;
		} // 간선 리스트 생성

		// 전처리 : 간선리스트 오름차순 정렬
		Arrays.sort(edgeList);

		// 1. make set
		make();

		// 2.정렬된 간선 하나씩 꺼내 신장트리 생성
		long weight = 0;
		int cnt = 0;

		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to))
				continue;
			weight += edge.weight;
			if(++ cnt == V - 1) break; // 최소 신장 트리 완성
		}
		if(cnt == V - 1)
			System.out.println(amount - weight);
		else System.out.println(-1);
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = find(parents[a]); // 경로 압축
	}

	private static void make() {
		parents = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}
