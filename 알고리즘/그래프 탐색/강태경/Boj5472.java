package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj5472 {
	
	
	static int w, h, answer;
	static boolean possible;
	static char[][] map;
	static Deque<Pair> fires;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static class Pair{
		int x;
		int y;
		int time;
		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	
	static void bfs(Pair start) {
		Deque<Pair> q = new ArrayDeque<>();
		q.add(start);
		while(!q.isEmpty()) {
			Pair now = q.remove();
			int time = now.time;
			if(time==answer) spread();
			for(int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w) {
					possible = true;
					return;
				}
				if(map[nx][ny]!='.') continue;
				map[nx][ny] = '@';
				q.add(new Pair(nx, ny, time+1));
			}
		}
	}
	
	static void spread() {
		if(fires.isEmpty()) {
			answer++;
			return;
		}
		while(!fires.isEmpty()) {
			Pair now = fires.remove();
			int time = now.time;
			if(now.time>answer) {
				fires.addFirst(now);
				answer++;
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w||map[nx][ny]=='*'||map[nx][ny]=='#') continue;
				map[nx][ny] = '*';
				fires.add(new Pair(nx, ny, time+1));
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			stk = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			map = new char[h][w];
			Pair start = null;
			fires = new ArrayDeque<>();
			for(int i=0; i<h;i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='@') {
						start = new Pair(i, j, 0);
					} else if(map[i][j]=='*') {
						fires.add(new Pair(i, j, 0));
					}
				}
			}
			answer = 0;
			possible = false;
			bfs(start);
			if(possible) sb.append(answer);
			else sb.append("IMPOSSIBLE");
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
}