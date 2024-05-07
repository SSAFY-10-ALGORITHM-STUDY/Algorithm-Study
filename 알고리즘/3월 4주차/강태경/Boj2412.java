import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2412 {

    static class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static void bfs() {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 0));
        boolean[] visit = new boolean[n];
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y= now.y;
            int dist = now.dist;
            for (int i = 0; i < 5; i++) {
                int nx = x+dx[i];
                for (int j = 0; j < 5; j++) {
                    int ny = y+dy[j];
                    Pair next = new Pair(nx, ny, dist+1);
                    if(exist.containsKey(next)&&!exist.get(next)){
                        if(ny==t) {
                            answer = dist+1;
                            return;
                        }
                        exist.put(next,true);
                        q.add(next);
                    }
                }

            }
        }
    }

    static int[] dx = {-2,-1,0,1, 2};
    static int[] dy = {-2,-1,0, 1, 2};

    static int n, t, answer;
    static Map<Pair, Boolean> exist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        exist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            exist.put(new Pair(x, y, 0), false);
        }
        answer = 100000;
        bfs();
        if(answer==100000) sb.append(-1);
        else sb.append(answer);
        System.out.println(sb);
    }
}