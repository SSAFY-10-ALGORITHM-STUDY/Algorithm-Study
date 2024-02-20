package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		int answer = 0;
		stk = new StringTokenizer(br.readLine());
		while(m-->0) {
			int position = Integer.parseInt(stk.nextToken());
			int num = 0;
			while(position != q.peek()) {
				q.add(q.remove());
				num++;
			}
			answer+=Math.min(num, q.size()-num);
			q.remove();
		}
		sb.append(answer);
		System.out.println(sb);
	}
}