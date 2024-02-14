package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5427 {

	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, -1, 0, 1 };
	static int fire[][] = new int[1001][1001];
	static int mat[][] = new int[1001][1001];
	static boolean visited[][] = new boolean[1001][1001];
	static boolean visitedFire[][] = new boolean[1001][1001];
	static int w, h, ans;
	static Queue<Pair> fq;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(in.readLine());

		while (t-- > 0) {
			fq = new LinkedList<>();
			st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			int sy = 0, sx = 0;

			for (int i = 0; i < h; i++) {
				String s = in.readLine();
				for (int j = 0; j < w; j++) {
					fire[i][j] = 1000001;
					visited[i][j] = false;
					visitedFire[i][j] = false;
					if (s.charAt(j) == '.')
						mat[i][j] = 1;
					if (s.charAt(j) == '#')
						mat[i][j] = 2;
					if (s.charAt(j) == '@') {
						mat[i][j] = 3;
						sy = i;
						sx = j;
					}
					if (s.charAt(j) == '*') {
						mat[i][j] = 4;
						fire[i][j] = 1;
						fq.add(new Pair(i, j));
						visitedFire[i][j] = true;
					}

				}
			}

			bfsFire();
			ans = 1000001;
			bfs(sy, sx);

			if (ans != 1000001)
				System.out.println(ans);
			else
				System.out.println("IMPOSSIBLE");
		}
	}

	private static void bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(y, x, 1));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Pair tmp = q.poll();
			int sy = tmp.y;
			int sx = tmp.x;
			int curCnt = tmp.cnt;
			for (int i = 0; i < 4; i++) {
				int ny = sy + dy[i];
				int nx = sx + dx[i];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
					ans = curCnt;
					return;
				}
				if (mat[ny][nx] == 1 && fire[ny][nx] > curCnt + 1 && visited[ny][nx] == false) {
					q.add(new Pair(ny, nx, curCnt + 1));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static void bfsFire() {
		while (!fq.isEmpty()) {
			Pair tmp = fq.poll();
			int sy = tmp.y;
			int sx = tmp.x;
			for (int i = 0; i < 4; i++) {
				int ny = sy + dy[i];
				int nx = sx + dx[i];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w)
					continue;
				if (mat[ny][nx] != 2 && visitedFire[ny][nx] == false) {
					fire[ny][nx] = fire[sy][sx] + 1;
					fq.add(new Pair(ny, nx));
					visitedFire[ny][nx] = true;
				}
			}
		}
	}

	static class Pair {
		int y;
		int x;
		int cnt;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

		Pair(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
