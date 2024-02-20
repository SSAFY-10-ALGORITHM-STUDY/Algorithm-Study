package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Deque<Long> q = new ArrayDeque<>();
		Deque<Long> q2 = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			q.addFirst(Long.parseLong(br.readLine()));
		}
		q2.add(q.removeLast());
		long answer = 0L;
		long buf = 1L;
		while (!q.isEmpty()) {
			long first = q2.removeLast(); // 12 13 14
			long second = q.removeLast(); // 2
			if (first > second) {
				q2.add(first);
				q2.add(second);
				answer += buf;
				buf++;
			} else {
				buf--;
				if (q2.isEmpty()) {
					q2.add(second);
					buf=1L;
				} else {
					q.add(second);
				}
			}
		}

		System.out.println(answer);
	}

}