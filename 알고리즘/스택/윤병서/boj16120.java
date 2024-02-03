/*
스택에 문자열을 넣으며 A 다음 P가 나오면 앞에 P가 2개 이상 있는 경우 PPAP -> P로 변환
PP. A 등 반례가 존재함
*/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj16120 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();

		Stack<Character> st = new Stack<>();
		boolean chk = true;

		int p = 0, a = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'P') {
				if (a > 0) {
					if(p < 2) {
						chk = false;
						break;
					}
					else {
						st.pop();
						st.pop();
						a --;
						p --;
					}
					
				} else {
					p++;
					st.add('P');
				}
			} else {
				if(a > 0) {
					chk = false;
					break;
				}
				a++;
				st.add('A');
			}
		}
		if(chk == true && st.size() <= 1 && st.peek() == 'P') System.out.println("PPAP");
		else System.out.println("NP");
	}
}
