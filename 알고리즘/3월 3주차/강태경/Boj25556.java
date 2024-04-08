import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj25556 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Deque<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayDeque<>());
        }
        stk = new StringTokenizer(br.readLine());
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(stk.nextToken());
            boolean isIn = false;
            for (int j = 0; j < 4; j++) {
                if (list.get(j).isEmpty()) {
                    list.get(j).add(now);
                    isIn = true;
                    break;
                } else {
                    if (list.get(j).peekLast() < now) {
                        list.get(j).add(now);
                        isIn = true;
                        break;
                    }
                }
            }
            if(!isIn) {
                possible = false;
                break;
            }
        }

        if (possible) sb.append("YES");
        else sb.append("NO");
        System.out.println(sb);
    }
}