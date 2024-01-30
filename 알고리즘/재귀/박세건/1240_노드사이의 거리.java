N이 1000이라는 범위에 재귀를 돌리면 터질거 같다고 생각했다.
트리 구조라는 점에서 한쪽방향으로 탐색을 진행했을때에 방문처리를 복구시켜주지 않아도 됨을 알게되었다.
따라서 총 경우의 수는 1000^2 이라고 생각한다.
  ----------코드----------
  package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<MyPair> lists[];
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;
	static boolean visited[];
	static boolean flag = false;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder resultString = new StringBuilder();
		setting();
		for (int i = 0; i < M; i++) {
			visited = new boolean[N + 1];
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			flag = false;
			answer = 0;
			findDistance(0, a, b);
			resultString.append(answer).append("\n");
		}
		System.out.println(resultString);
	}

	private static void findDistance(int sum, int a, int b) {
		if (a == b) {
			answer = sum;
			flag = true;
			return;
		}
		if (flag == true) {
			return;
		}
		visited[a] = true;
		for (int i = 0; i < lists[a].size(); i++) {
			int tmp = lists[a].get(i).getFirst();
			int dis = lists[a].get(i).getSecond();
			if (visited[tmp] == false) {
				visited[tmp] = true;
				findDistance(sum + dis, tmp, b);
			}
		}
	}

	private static void setting() throws IOException {
		tokenizer = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<>();
		}
		M = Integer.parseInt(tokenizer.nextToken());
		for (int i = 0; i < N - 1; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			int val = Integer.parseInt(tokenizer.nextToken());
			lists[x].add(new MyPair(y, val));
			lists[y].add(new MyPair(x, val));
		}
	}

}

class MyPair {
	private int first;
	private int second;

	public MyPair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
