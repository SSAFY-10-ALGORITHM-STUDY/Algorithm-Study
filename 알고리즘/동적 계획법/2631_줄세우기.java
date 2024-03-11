package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static boolean isSpecialSeat[];
	static int answer = 1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		isSpecialSeat = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(br.readLine());
			isSpecialSeat[x] = true;
		}
		int before = 1;
		int cur = 1;
		for (int i = 1; i < N + 1; i++) {
			if (isSpecialSeat[i] == true) {
				answer *= before;
				before = 1;
				cur = 1;
				continue;
			}
			int x = cur;
			cur = before + cur;
			before = x;
		}

		System.out.println(answer * before);
	}
}
