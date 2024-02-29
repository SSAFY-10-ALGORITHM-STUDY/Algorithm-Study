DFS를 사용해서 바로 이전에 방문했던 곳을 제외한 곳중에서 탐색을 진행합니다.
탐색을 진행하면서 이미 탐색을 했던 곳을 방문하게 되었다면 탐색했던 곳들중에 순환이 존재한다는 의미입니다.
만약 이미 탐색했던 곳을 방문해서 탐색이 종료되었다고 그때까지 진행했던 방문의 길이는 순환을 포함한 길이가 됩니다.
이 모든 길이를 확인했을때에 가장 작은 길이는 바로 순환선의 총 길이가 되기때문에 이를 전체에서 빼준뒤 출력합니다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer> connectInfo[];
	static boolean visited[];
	static boolean isCycle[];
	static int distance[];
	static int cycleDis = Integer.MAX_VALUE;
	static StringBuilder answerString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		setting();
		for (int i = 1; i < N + 1; i++) {
			visited[i] = true;
			findCycle(i, i, -1, 0);
			visitedInit();
		}
		for (int i = 1; i < N + 1; i++) {
			answerString.append(distance[i] - cycleDis).append(" ");
		}
		System.out.println(answerString);
	}

	private static void visitedInit() {
		for (int i = 1; i < N + 1; i++) {
			visited[i] = false;
		}
	}

	private static void findCycle(int start, int cur, int before, int cnt) {
		// System.out.println(cur + " " + before);
		for (int i = 0; i < connectInfo[cur].size(); i++) {
			int x = connectInfo[cur].get(i);
			if (x != before) {
				if (visited[x] == true) {
					if (distance[start] == 0) {
						distance[start] = cnt;
						cycleDis = Integer.min(cnt, cycleDis);
					}
					continue;
				}
				visited[x] = true;
				findCycle(start, x, cur, cnt + 1);
			}
		}
	}

	private static void setting() throws IOException {
		N = Integer.parseInt(reader.readLine());
		isCycle = new boolean[N + 1];
		visited = new boolean[N + 1];
		connectInfo = new List[N + 1];
		distance = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			connectInfo[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			connectInfo[a].add(b);
			connectInfo[b].add(a);

		}
	}
}
