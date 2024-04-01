package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2412 {
	static class Pair {
		int y, x;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		Map<Pair, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(new Pair(x, y), Integer.MAX_VALUE);
		}
		map.put(new Pair(0, 0), 0);
		
		Queue<Pair> q = new ArrayDeque<>();
		
		q.add(new Pair(0, 0));
	
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int i = cur.y - 2; i <= cur.y + 2; i ++) {
				for(int j = cur.x - 2; j <= cur.x + 2; j ++) {
					Pair tmp = new Pair(j, i);
					if(map.containsKey(tmp) && map.get(tmp) > map.get(cur) + 1) {
						map.put(tmp, map.get(cur) + 1);
						q.add(tmp);
						if(i == t) {
							System.out.println(map.get(tmp));
							return;
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
