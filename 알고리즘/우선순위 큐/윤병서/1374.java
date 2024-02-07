package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj1374 {
	static class Pair {
		int st;
		int ed;

		public Pair(int y, int x) {
			this.st = y;
			this.ed = x;
		}
	}

	static class PairComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.st == o2.st) {
				return o1.ed - o2.ed;
			} else
				return o1.st - o2.st;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Pair> list = new ArrayList<>();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Pair(a, b));
		}
		
		Collections.sort(list, new PairComparator());
		
		pq.add(list.get(0).ed);
		for(int i = 1 ; i < n ; i ++) {
			if(pq.peek() <= list.get(i).st) {
				pq.poll();
				pq.add(list.get(i).ed);
			}
			else {
				pq.add(list.get(i).ed);
			}
		}
		System.out.println(pq.size());
	}
}
