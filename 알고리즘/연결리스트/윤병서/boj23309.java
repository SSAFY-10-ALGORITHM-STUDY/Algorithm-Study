package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj23309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer arrToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrToken.nextToken());
        }

        Pair[] v = new Pair[1000001];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                v[arr[0]] = new Pair(arr[n - 1], arr[1]);
            } else if (i == n - 1) {
                v[arr[n - 1]] = new Pair(arr[n - 2], arr[0]);
            } else {
                v[arr[i]] = new Pair(arr[i - 1], arr[i + 1]);
            }
        }

        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("BN")) {
                int cur = Integer.parseInt(st.nextToken());
                int nxt = Integer.parseInt(st.nextToken());
                System.out.println(v[cur].second);
                v[v[cur].second] = new Pair(nxt, v[v[cur].second].second);
                v[nxt] = new Pair(cur, v[cur].second);
                v[cur] = new Pair(v[cur].first, nxt);
            } else if (a.equals("BP")) {
                int cur = Integer.parseInt(st.nextToken());
                int prev = Integer.parseInt(st.nextToken());
                System.out.println(v[cur].first);
                v[v[cur].first] = new Pair(v[v[cur].first].first, prev);
                v[prev] = new Pair(v[cur].first, cur);
                v[cur] = new Pair(prev, v[cur].second);
            } else if (a.equals("CN")) {
                int cur = Integer.parseInt(st.nextToken());
                System.out.println(v[cur].second);
                int nxtNode = v[cur].second;
                v[v[nxtNode].second] = new Pair(cur, v[v[nxtNode].second].second);
                v[cur] = new Pair(v[cur].first, v[nxtNode].second);
                v[nxtNode] = new Pair(0, 0);
            } else {
                int cur = Integer.parseInt(st.nextToken());
                System.out.println(v[cur].first);
                int prevNode = v[cur].first;
                v[v[prevNode].first] = new Pair(v[v[prevNode].first].first, cur);
                v[cur] = new Pair(v[prevNode].first, v[cur].second);
                v[prevNode] = new Pair(0, 0);
            }
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
