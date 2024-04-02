x, y 좌표를 Map에 저장해주기 위해서 String 을 key로 사용하려 했지만 메모리 초과가 밠생
  이 문제를 해결하기위해서 long의 범위로 좌표를 표현 -> ex) 10000,50000을 표현하기위해서 1000050000 으로 표현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, T;
	static Map<Long, Boolean> isHom = new HashMap<>();
	static int answerCnt;
	static boolean isPossibleCase;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		if (isPossibleCase) {
			function(0, 0);
			System.out.println(answerCnt);
		} else {
			System.out.println(answerCnt);
		}
	}

	private static void function(int sx, int sy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sx, sy, 0 });
		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int moveCnt = queue.peek()[2];
//			System.out.println(x + " " + y + " " + moveCnt);
			queue.poll();
			if (y == T) {
				answerCnt = moveCnt;
				return;
			}
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++) {
					int dx = x + i;
					int dy = y + j;
					if (dx >= 0 && dx <= 1000000 && dy >= 0 && dy <= T) {
						long tmp = (long) (dx * 1000000 + dy);
						if (isHom.get(tmp) != null && isHom.get(tmp) == true) {
							isHom.put(tmp, false);
							queue.add(new int[] { dx, dy, moveCnt + 1 });
						}
					}
				}
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		answerCnt = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			isHom.put((long) (x * 1000000 + y), true);
			if (y == T) {
				isPossibleCase = true;
			}
		}
	}
}
