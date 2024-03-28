1. 입력 받기
2. 입력받은 데이터로 하나의 값에 3으로 나눠지는 값과 2를 곱했을때에 값이 존재하는지 확인하고 존재하면 index 연결
3. 백트래킹을 사용해서 가능한 나3과 곱2 를 모두 탐색


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static class Node {
		int divideIdx;
		long value;
		int multiIdx;

		public Node(long value) {
			super();
			this.divideIdx = -1;
			this.value = value;
			this.multiIdx = -1;
		}

		@Override
		public String toString() {
			return "Node [divideIdx=" + divideIdx + ", value=" + value + ", multiIdx=" + multiIdx + "]";
		}

	}

	static int N;
	static Node[] nodes;
	static long[] answerArr;
	static boolean findAnswerFlag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		setting();
		function();
		System.out.println(answer);

	}

	private static void function() {
		for (int i = 0; i < N; i++) {
			backTracking(i, 0);
		}
		for (int i = 0; i < N; i++) {
			answer.append(answerArr[i]).append(" ");
		}
	}

	private static void backTracking(int idx, int cnt) {
		if (findAnswerFlag) {
			return;
		}
		long val = nodes[idx].value;
		answerArr[cnt] = val;
		if (cnt == N - 1) {
			findAnswerFlag = true;
			return;
		}
		if (nodes[idx].divideIdx != -1) {
			backTracking(nodes[idx].divideIdx, cnt + 1);
		}
		if (nodes[idx].multiIdx != -1) {
			backTracking(nodes[idx].multiIdx, cnt + 1);
		}
	}

	private static void setting() {
		answerArr = new long[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					long iVal = nodes[i].value;
					long jVal = nodes[j].value;
					if (iVal * 2 == jVal) {
						nodes[i].multiIdx = j;
					}
					if (iVal % 3 == 0 && iVal / 3 == jVal) {
						nodes[i].divideIdx = j;
					}

				}
			}
		}
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long val = Long.parseLong(st.nextToken());
			nodes[i] = new Node(val);
		}
	}
}
