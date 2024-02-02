/*
c++ pair가 없어서 pair를 자체적으로 구현해서 사용
List<List<Piar>> 로 노드들을 연결해서 구현
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	Integer y;
	Integer x;

	public Pair(Integer y, Integer x) {
		this.y = y;
		this.x = x;
	}

	public Integer first() {
		return y;
	}

	public Integer second() {
		return x;
	}
}

public class Main {
	static List<List<Pair>> list = new ArrayList<>();
	static int n, m, ma;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list.get(a).add(new Pair(b, dist));
			list.get(b).add(new Pair(a, dist));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			visited = new boolean[n + 1];
			ma = 0;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			foo(a, b, 0);
			System.out.println(ma);
		}
	}

	private static void foo(int a, int b, int dist) {
		if (a == b) {
			ma = dist;
			return;
		}
		if (visited[a] == true)
			return;
		visited[a] = true;
		for (int i = 0; i < list.get(a).size(); i++) {
			foo(list.get(a).get(i).first(), b, dist + list.get(a).get(i).second());
		}
	}
}
