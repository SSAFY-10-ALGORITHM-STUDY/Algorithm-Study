package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj4779 {
	static StringBuilder ans;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while((input = in.readLine()) != null) {
			int n = Integer.parseInt(input);
			ans = new StringBuilder();
			int tmp = (int) Math.pow(3, n);
			for(int i = 0 ; i < tmp; i ++) {
				ans.append("-");
			}
			foo(0, tmp);
			System.out.println(ans);
		}
	}

	private static void foo(int start, int end) {
		if(end - start < 3) return;
		int mod = (end - start) / 3;
		for(int i = start + mod ; i < start + 2 * mod; i ++) {
			ans.setCharAt(i, ' ');
		}
		foo(start, end - 2 * mod);
		foo(end - mod, end);
	}
}
