플로이드 워셜 알고리즘 이용
O(n^3) => 500*500*500
  A에서 B로 갈때에 A->C, C->B 의 거리를 비교해서 원래의 길이와 비교해서 작은 값을 유지한다.
  주의해야할 것은 중간다리가 될 수 있는 정점을 정해서 그 기준으로 모든 정점을 비교한 후에 다음 단계를 넘어간다

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] connInfo;

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int answer;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		connInfo = new int[N][N];
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				connInfo[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}

		}

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++) {
					if (i != k && j != k) {
						connInfo[i][j] = Math.min(connInfo[i][j], connInfo[i][k] + connInfo[k][j]);
						connInfo[j][i] = Math.min(connInfo[j][i], connInfo[j][k] + connInfo[k][i]);
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int s = Integer.parseInt(stringTokenizer.nextToken());
			int e = Integer.parseInt(stringTokenizer.nextToken());
			int t = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println((connInfo[s - 1][e - 1] <= t) ? "Enjoy other party" : "Stay here");
		}
	}
}
