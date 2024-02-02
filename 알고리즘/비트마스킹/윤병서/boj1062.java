/*
주어진 anta, tica에 대한 선 처리
비트마스킹을 이용해 알파벳 26개에 대한 상태 처리
불필요한 재귀로 인한 시간 초과 발생했었음
*/

package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1062 {
	static int n, k;
	static int ans;
	static String[] s;
	static int bit;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		k -= 5;
		s = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = in.readLine();
		}

		if (k < 0) {
			System.out.println(0);
			return;
		}

		bit |= (1 << ('a' - 'a'));
		bit |= (1 << ('c' - 'a'));
		bit |= (1 << ('i' - 'a'));
		bit |= (1 << ('n' - 'a'));
		bit |= (1 << ('t' - 'a'));

		foo(0, bit, 1);

		System.out.println(ans);
	}

	private static void foo(int cnt, int bit, int idx) {
		if(cnt == k) {
			int can = 0;
			for(int i = 0 ; i < n ; i ++) {
				boolean chk = true;
				for(int j = 0 ; j < s[i].length(); j ++) {
					int curChar = s[i].charAt(j) - 'a';
					if((bit & (1 << curChar)) != (1 << curChar)) {
						chk = false;
					}
					if(chk == false) break;
				}
				if(chk == true) can ++;
			}
			if(ans < can) ans = can;
			return;
		}
		
		if(idx == 26) return;
		
		for(int i = idx; i < 26; i ++) {
			if((bit | (1 << i)) != bit) {
				foo(cnt + 1, bit | (1 << i), i + 1);
			}
		}
	}
}
