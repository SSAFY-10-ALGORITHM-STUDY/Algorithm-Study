import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.temporal.IsoFields;
import java.util.*;

public class Boj16947 {

    static void findCycle(int now) {
        if (isFind) return;
        for (int next : edges.get(now)) {
            if (isFind) return;
            if (!visit[next]) {
                parent[next] = now;
                visit[next] = true;
                findCycle(next);
            } else {
                if (next != parent[now]) {
                    int idx = now;
                    isCycle[next] = true;
                    while (idx != next) {
                        isCycle[idx] = true;
                        idx = parent[idx];
                    }
                    isFind = true;
                    return;
                }
            }
        }
    }

    static class Pair{
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int getDistance(int start) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, 0));
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int now = p.node;
            int dist = p.dist;
            for (int next : edges.get(now)) {
                if (!visit[next]) {
                    if(isCycle[next]){
                        return dist+1;
                    }
                    visit[next] = true;
                    q.add(new Pair(next, dist+1));
                }
            }

        }
        return 0;
    }

    static List<ArrayList<Integer>> edges;
    static int n;
    static int[] parent, dist;
    static boolean isFind;
    static boolean[] visit, isCycle;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        visit = new boolean[n + 1];
        parent = new int[n + 1];
        parent[1] = 1;
        visit[1] = true;
        isFind = false;
        isCycle = new boolean[n + 1];
        findCycle(1);
        for (int i = 1; i <= n; i++) {
            if (!isCycle[i]) {
                sb.append(getDistance(i)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

    }
}