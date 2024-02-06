package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3078 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long ans = 0;
		int[] sz = new int[21];

		Queue<String> q = new LinkedList<>();
		
		int idx = 0;
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			if (i == 0) {
				q.add(str);
				sz[str.length()]++;
			} else {
				ans += sz[str.length()];
				q.add(str);
				sz[str.length()]++;
				if(i == k + idx) {
					String tmp = q.poll();
					idx ++;
					sz[tmp.length()] --;
				}
			}
		}

		System.out.println(ans);
	}
}
