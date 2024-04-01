package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5904 {

	static long[] moo;
	static int n;

	static char find(int idx) {
		if (idx == 0) {
			if (n == 1) {
				return 'm';
			} else
				return 'o';
		}
		if (n <= moo[idx - 1]) {
			return find(idx - 1);
		} else if (n == moo[idx - 1] + 1) {
			return 'm';
		} else if (n <= moo[idx - 1] + idx + 3) {
			return 'o';
		} else {
			n -= moo[idx - 1] + idx + 3;
			return find(idx - 1);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		int size = 30;
		moo = new long[size];
		moo[0] = 3;
		for (int i = 1; i < size; i++) {
			moo[i] = moo[i - 1] * 2 + i + 3;
		}
		sb.append(find(size));
		System.out.println(sb);
	}
}
