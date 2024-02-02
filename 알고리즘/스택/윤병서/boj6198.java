/*
아이디어가 어려웠던 문제
스택을 이용해 가장 큰 수가 들어올때마다 빼며 카운트
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> s = new Stack<>();

		int n = Integer.parseInt(in.readLine());
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(in.readLine());
			if (i == 0) {
				s.add(a);
				continue;
			}
			while (s.empty() == false && s.peek() <= a) {
				s.pop();
			}
			ans += s.size();
			s.push(a);
		}
		System.out.println(ans);
	}
}
