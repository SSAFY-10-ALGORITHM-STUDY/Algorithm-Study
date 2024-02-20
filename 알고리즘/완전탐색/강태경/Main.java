package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int answer = -1;
	static int[][] arr;

	static void find(int x, int y, int dx, int dy) {
		int buf = 0;
		while (x >= 0 && x < n && y >= 0 && y < m) {
			buf = buf * 10 + arr[x][y];
			if (isSquare(buf))
				answer = Math.max(answer, buf);
			if(dx==0&&dy==0) break;
			x += dx;
			y += dy;
		}
	}

	static boolean isSquare(int n) {
		return Math.pow((int)(Math.pow(n, 0.5)), 2) == n;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = -8; k <= 8; k++) {
					for (int l = -8; l <= 8; l++) {
						find(i, j, k, l);
					}
				}
			}
		}
		sb.append(answer);
		System.out.println(sb);
	}
}