중위순회를 기준으로 마지막에 탐색하게되는 노드를 미리 구한다
모든 노드를 탐색하고 이전에 구했던 마지막 노드를 탐색했을때에 횟수를 출력한다.

-----------------------코드-----------------------

  import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int treeInfo[][];
	static long answer;
	static int finalTarget = 1;
	static int nodeCnt;

	static StringBuilder resultString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		setting();
		findFinalTarget(1);
		findAnswer(1, 0);
		System.out.println(answer);
	}

	private static long findAnswer(int cur, long cnt) {
		nodeCnt++;
		int leftNode = treeInfo[cur][0];
		int rightNode = treeInfo[cur][1];
		if (leftNode != -1) {
			cnt = findAnswer(leftNode, cnt + 1) + 1;
		}
		if (rightNode != -1) {
			cnt = findAnswer(rightNode, cnt + 1) + 1;
		}
		if (cur == finalTarget && nodeCnt >= N) {
			answer = cnt;
		}
		return cnt;
	}

	private static void findFinalTarget(int cur) {
		int leftNode = treeInfo[cur][0];
		int rightNode = treeInfo[cur][1];
		if (leftNode != -1) {
			findFinalTarget(leftNode);
		}
		finalTarget = cur;
		if (rightNode != -1) {
			findFinalTarget(rightNode);
		}
	}

	private static void setting() throws IOException {
		N = Integer.parseInt(reader.readLine());
		treeInfo = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			treeInfo[a][0] = b;
			treeInfo[a][1] = c;
		}
	}

}
