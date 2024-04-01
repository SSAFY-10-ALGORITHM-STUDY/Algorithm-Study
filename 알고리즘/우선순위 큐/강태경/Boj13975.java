package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13975 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int k = Integer.parseInt(br.readLine());
			stk = new StringTokenizer(br.readLine());
			PriorityQueue<Long> q = new PriorityQueue<>();
			for(int i=0; i<k;i++) {
				q.add(Long.parseLong(stk.nextToken()));
			}
			long answer = 0;
			while(q.size()>1) {
				long first = q.remove();
				long second = q.remove();
				long next = first+second;
				answer+=next;
				q.add(next);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}