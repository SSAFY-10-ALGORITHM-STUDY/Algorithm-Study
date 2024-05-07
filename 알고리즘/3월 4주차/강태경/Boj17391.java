import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj17391 {

    static int n, m, answer;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx ={1, 0};
    static int[] dy = {0, 1};

    static class Pair{
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static void bfs(){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 1));
        visit = new boolean[n][m];
        visit[0][0] = true;
        while(!q.isEmpty()){
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            for (int i = 0; i < 2; i++) {
                for(int j=1; j<=map[x][y];j++){
                    int nx = x+dx[i]*j;
                    int ny = y+dy[i]*j;
                    if(nx==n-1&&ny==m-1){
                        answer = dist;
                        return;
                    }
                    if(nx>=n||ny>=m||visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    q.add(new Pair(nx, ny, dist+1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }

        }
        bfs();
        sb.append(answer);
        System.out.println(sb);
    }
}