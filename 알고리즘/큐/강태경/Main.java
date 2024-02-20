package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while (q.size() >= k) {
			q.add(q.remove());
			for (int i = 1; i < k; i++) {
				q.remove();
			}
		}
		System.out.println(q.remove());
	}

}