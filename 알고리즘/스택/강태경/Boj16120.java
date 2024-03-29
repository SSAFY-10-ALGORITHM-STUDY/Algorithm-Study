package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj16120 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		Deque<Character> q = new ArrayDeque<>();
		String s = br.readLine();
		boolean possible = true;
		for(int i=0; i<s.length(); i++) {
			if(!possible) break;
			char now = s.charAt(i);
			if(now=='P') {
				if(!q.isEmpty()) {
					char prev = q.peekLast();
					if(prev=='B') q.removeLast();
				}
				q.add(now);
			}
			else if(now=='A'){
				if(q.size()<2) {
					possible=false;
					break;
				}
				for(int j=0; j<2;j++) {
					char prev = q.removeLast();
					if(prev!='P') {
						possible = false;
						break;
					}
				}
				if(possible) {
					q.add('B');
				}
			}
		}
		if(!(q.size()==1&&q.peek()=='P')) possible=false;
		if(possible) sb.append("PPAP");
		else sb.append("NP");
		System.out.println(sb);
	}
}