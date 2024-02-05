package S0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15661 {

	static int[][] s;
	static int min = Integer.MAX_VALUE;
	static int n = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(" ");
		n = Integer.parseInt(in.readLine());
		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		team(1);
		System.out.println(min);
	}

	private static void team(int cnt) {
		if (cnt > (1 << (n - 1)))
			return;

		int[] a = new int[n];
		int[] b = new int[n];
		int lengthA = 0;
		int lengthB = 0;
		for (int i = 0; i < n; i++) {
			if ((cnt & (1 << i)) == 0) {
				a[lengthA] = i;
				lengthA++;
			} else {
				b[lengthB] = i;
				lengthB++;
			}
		}
		int scoreA = score(a, lengthA);
		int scoreB = score(b, lengthB);
		min = Math.min(min, Math.abs(scoreA - scoreB));
		team(cnt + 1);

	}

	private static int score(int[] sum, int length) {
		int score = 0;
		for (int i = 0; i < length; i++) {
			int x = sum[i];
			for (int j = i + 1; j < length; j++) {
				int y = sum[j];
				score += s[x][y] + s[y][x];
			}
		}
		return score;
	}
}