/*

n + m C n (n + m개의 알파벳 중에서 n개의 a를 선택)
dp를 통해 조합의 계산 값을 저장
10억이 넘을 경우 10억으로 값 축소

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		solution();
	}
    
	public static void solution() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n + m + 1][n + 1];

		if (comb(n + m, n) < k) {
			System.out.println(-1);
		} else {
			foo(n, m, k);
			System.out.println(sb.toString());
		}

	}

	private static int comb(int n, int r) {
		if(n == r || r == 0) return 1;
		if(n < 0 || r < 0) return 0;
		if(dp[n][r] > 0) return dp[n][r];

		dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
		if(dp[n][r] > 1000000000) dp[n][r] = 1000000000;

		return dp[n][r];
	}

	private static void foo(int n, int m, int k) {
		int tmp = comb(n + m - 1, n - 1);
		if(n > 0 && k <= tmp){
			sb.append('a');
			foo(n - 1, m , k);
		}
		else if(m > 0){
			sb.append('z');
			foo(n, m - 1, k - tmp);
		}
	}
}
