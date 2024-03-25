import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj16437 {

    static class Island {
        boolean isSheep;
        int count;
        List<Integer> edges;

        public Island() {
            edges = new ArrayList<>();
        }
    }


    static int n;
    static List<Island> list;
    static boolean[] visit;

    static long dfs(int now) {
        Island island = list.get(now);
        List<Integer> edges = island.edges;
        long leftWoolf = 0;
        long leftSheep = 0;
        int count = island.count;
        if (island.isSheep) {
            leftSheep = count;
        } else {
            leftWoolf = count;
        }
        for (Integer edge : edges) {
            if (!visit[edge]) {
                visit[edge] = true;
                leftSheep += dfs(edge);
                if (leftWoolf >= leftSheep) {
                    leftWoolf -= leftSheep;
                    leftSheep = 0;
                } else {
                    leftSheep -= leftWoolf;
                    leftWoolf = 0;
                }
            }
        }
        return leftSheep;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new Island());
        }

        for (int i = 2; i <= n; i++) {
            Island now = list.get(i);
            StringTokenizer stk = new StringTokenizer(br.readLine());
            now.isSheep = stk.nextToken().equals("S");
            now.count = Integer.parseInt(stk.nextToken());
            int nextIdx = Integer.parseInt(stk.nextToken());
            now.edges.add(nextIdx);
            list.get(nextIdx).edges.add(i);
        }

        visit = new boolean[n + 1];
        visit[1] = true;
        long answer = dfs(1);
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
}