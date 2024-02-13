package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13975 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(in.readLine());
		for(int i = 0 ; i < t; i ++) {
			int k = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			long ans = 0L;
			for(int j = 0 ; j < k; j ++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			while(pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				pq.add(a + b);
				ans += a+b;
			}
			System.out.println(ans);
		}
	}
}
