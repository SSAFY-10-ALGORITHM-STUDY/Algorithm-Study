기존의 재귀를 통한 조합을 찾는 알고리즘에서 메모리와 속도를 줄이기위해 사용한 알파벳을 저장해두는 것이아닌 
사용한 알파벳에 대한 정보를 비트로 나타내어서 해결한다.

------------코드------------

package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int inputInfo[];
	static Map<Character, Integer> alpha = new HashMap<>();
	static int answer = 0;

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;
	static StringBuilder resultString = new StringBuilder();

	public static void main(String[] args) throws IOException {
		setting();
		findAnswer(0, 0, 0);
		System.out.println(answer);
	}

	private static void findAnswer(int start, int cnt, int bitMasking) {
		if (cnt == K) {
			int sum = 0;
			for (int i = 0; i < inputInfo.length; i++) {
				if ((inputInfo[i] & bitMasking) == inputInfo[i]) {
					sum++;
				}
			}
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = start; i < 26; i++) {
			int idx = alpha.get((char) ('a' + i));
			findAnswer(i + 1, cnt + 1, bitMasking | 1 << idx);
		}
	}

	private static void setting() throws IOException {
		tokenizer = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());
		inputInfo = new int[N];
		for (int i = 0; i < 26; i++) {
			alpha.put((char) ('a' + i), 26 - i - 1);
		}
		for (int i = 0; i < N; i++) {
			String tmp = reader.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				int idx = alpha.get(tmp.charAt(j));
				inputInfo[i] = inputInfo[i] | 1 << idx;
			}
		}
	}

}
