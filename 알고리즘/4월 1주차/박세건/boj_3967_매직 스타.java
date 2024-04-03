알파벳이 정해지지 않은 X의 좌표를 저장한뒤 모든 x를 순서대로 채웠을때에 모든 선의 합이 26인지를 확인

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int N = 5, M = 9;
	static int[][] lineInfo;
	static boolean[] visited = new boolean[13];
	static int linePoints[][][] = { { { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 } },
			{ { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 } }, { { 1, 1 }, { 1, 3 }, { 1, 5 }, { 1, 7 } },
			{ { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } }, { { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 } },
			{ { 3, 1 }, { 3, 3 }, { 3, 5 }, { 3, 7 } } };
	static int[][] points = { { 0, 4 }, { 1, 1 }, { 1, 3 }, { 1, 5 }, { 1, 7 }, { 2, 2 }, { 2, 6 }, { 3, 1 }, { 3, 3 },
			{ 3, 5 }, { 3, 7 }, { 4, 4 } };
	static boolean isFindAnswer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		backTracking(0);
//		for (int i = 0; i < lineInfo.length; i++) {
//			System.out.println(Arrays.toString(lineInfo[i]));
//		}
	}

	private static void backTracking(int cnt) {
		if (isFindAnswer) {
			return;
		}
		if (cnt == 12) {
			if (isLinesValid()) {
				isFindAnswer = true;
				// 맵 출력
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
			}
			return;
		}
		if (map[points[cnt][0]][points[cnt][1]] != 'x') {
			backTracking(cnt + 1);
		} else {
			for (int i = 'A'; i < 'A' + 12; i++) {
				if (visited[i - 'A' + 1] == false) {
					visited[i - 'A' + 1] = true;
					map[points[cnt][0]][points[cnt][1]] = (char) i;
					backTracking(cnt + 1);
					map[points[cnt][0]][points[cnt][1]] = 'x';
					visited[i - 'A' + 1] = false;
				}
			}
		}
	}

	private static boolean isLinesValid() {
		for (int i = 0; i < 6; i++) {
			int sum = 0;
			// 탐색중인 라인의 합을 구하기
			for (int j = 0; j < 4; j++) {
				sum += map[linePoints[i][j][0]][linePoints[i][j][1]] - 'A' + 1;
			}
			// 합이 26이 아닐때 백트래킹
			if (sum != 26) {
				return false;
			}
		}
		return true;
	}

	private static void input() throws IOException {
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] >= 'A' && map[i][j] <= 'L') {
					visited[map[i][j] - 'A' + 1] = true;
				}
			}
		}
	}
}
