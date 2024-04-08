package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj17828 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		if(x > 26 * n || n > x) {
			System.out.println("!");
			return;
		}
		
		Deque<Character> dq = new ArrayDeque<Character>();
		while(true) {
			if(x > 26 && x - 26 >= n - 1) {
				x -= 26;
				n --;
				dq.add('Z');
			}
			else break;
		}
		dq.push((char) (x - n + 'A'));
		n --;
		for(int i = 0 ; i < n ;i ++) {
			dq.push('A');
		}
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst());
		}
		System.out.println(sb);
//		System.out.println(dq.toString());
	}
}
