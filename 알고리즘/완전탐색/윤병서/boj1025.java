/*

재귀를 통한 완전탐색
n = 1, m = 1 반례에 틀렸음

*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans = -1, n, m;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}

		if (n == 1 && m == 1) {
			int tmp = (int) Math.sqrt(arr[0][0]);
			if ((int) Math.pow(tmp, 2) == arr[0][0])
				ans = Math.max(ans, arr[0][0]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++) {
						if (k == 0 && l == 0)
							continue;
						int start = arr[i][j];
						foo(i, j, k, l, start);
						foo(i, j, k, -l, start);
						foo(i, j, -k, l, start);
						foo(i, j, -k, -l, start);
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void foo(int i, int j, int k, int l, int cur) {
		int ny = i + k, nx = j + l;
		int tmp = (int) Math.sqrt(cur);
		if ((int) Math.pow(tmp, 2) == cur)
			ans = Math.max(ans, cur);
		if (ny < 0 || nx < 0 || ny >= n || nx >= m)
			return;
		int nxt = cur * 10 + arr[ny][nx];

		foo(ny, nx, k, l, nxt);
	}
}
