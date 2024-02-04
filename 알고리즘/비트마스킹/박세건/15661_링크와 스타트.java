팀을 결정하는 부분에서 비트마스킹을 사용
ex) 11의 경우 1번 2번 팀 / 3번 4번 팀
  101의 경우 1번 3 번 팀 / 2 번 4번 팀

  점수를 계산하는 부분에서는 모든 점수를 확인한뒤 팀의 정보와 일치하는지를 확인!

-----------------코드----------------


package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];
	static int answer = Integer.MAX_VALUE;

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;
	static StringBuilder resultString = new StringBuilder();

	public static void main(String[] args) throws IOException {
		setting();
		makeTeam(0, 0);
		System.out.println(answer);

	}

	// 1,2와 팀인경우와 3,4,가 팀인 경우는 같은 경우인데 중복하게 탐색한다
	// 해결할 방법이 있을까
	private static void makeTeam(int start, int curTeam) {
		if (curTeam > 0 && curTeam < Math.pow(2, N) - 1) {
			makeAnswer(curTeam);
		}
		for (int i = start; i < N; i++) {
			makeTeam(i + 1, curTeam | 1 << i);
		}
	}

	private static void makeAnswer(int curTeam) {
		int team1 = 0, team2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (((curTeam & (1 << i)) == (1 << i)) && ((curTeam & (1 << j)) == (1 << j))) {
					team1 += map[i][j] + map[j][i];
				} else if (((curTeam & (1 << i)) != (1 << i)) && ((curTeam & (1 << j)) != (1 << j))) {
					team2 += map[i][j] + map[j][i];
				}
			}
		}
		answer = Math.min(answer, Math.abs(team1 - team2));
	}

	private static void setting() throws IOException {
		N = Integer.parseInt(reader.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
	}

}
