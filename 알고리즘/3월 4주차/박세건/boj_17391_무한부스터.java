동적 계획법을 이용해서 이동할 수 있는 칸의 최솟값을 유지시켜준다

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dp;
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int answer;

	public static void main(String[] args) throws IOException {
		input();
		dp[0][0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 오른쪽 dp 값 저장
				for (int k = 1; k <= map[i][j] && j + k < M; k++) {
					dp[i][j + k] = Math.min(dp[i][j] + 1, dp[i][j + k]);
				}
				// 아래 dp 값 저장
				for (int k = 1; k <= map[i][j] && i + k < N; k++) {
//					System.out.println(i + k);
					dp[i + k][j] = Math.min(dp[i][j] + 1, dp[i + k][j]);
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(dp[N - 1][M - 1]);
	}

	private static void input() throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = 987654321;
			}
		}
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
	}
}
